package com.qfedu.order.service.impl;

import com.qfedu.order.domain.dto.DiscountDto;
import com.qfedu.order.domain.dto.OrderDto;
import com.qfedu.order.domain.entity.*;
import com.qfedu.order.mapper.OrderAddressMapper;
import com.qfedu.order.mapper.OrderMapper;
import com.qfedu.order.sendcallback.DefaultSendCallBack;
import com.qfedu.order.service.PointsService;
import com.qfedu.order.service.ProductService;
import com.qfedu.order.utils.GenerateCodeUtil;
import com.qfedu.order.common.RequestCode;
import com.qfedu.order.common.RequestEntity;
import com.qfedu.order.domain.dto.OrderRequestDto;
import com.qfedu.order.exception.ServiceException;
import com.qfedu.order.mapper.OrderItemMapper;
import com.qfedu.order.service.DiscountService;
import com.qfedu.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Description:
 * @author: zxl
 * @Data:2020/8/7
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Resource
    OrderItemMapper orderItemMapper;
    @Resource
    OrderAddressMapper orderAddressMapper;
    @Resource
    OrderMapper orderMapper;
    @Resource
    ProductService productService;
    @Resource
    DiscountService discountService;
    @Resource
    PointsService pointsService;
    @Resource
    RocketMQTemplate rocketMQTemplate;
    @Value("${topic.code}")
    String topicCode;

    /**
     * 生成订单
     *
     * @param orderRequestDto
     * @return
     */
    @Override
    public OrderDto create(OrderRequestDto orderRequestDto) {
        String ly = GenerateCodeUtil.createCodeNum("LY-");
        //List<Integer> ids = orderRequestDto.getIds();
        Integer id = orderRequestDto.getId();
        OrderDto orderDto = new OrderDto();
        //lambda表达式遍历集合
        //BigDecimal total = new BigDecimal(0);

        //Iterator<Integer> iterator = ids.iterator();
        //log.info(productService.listOne(iterator.next()).toString());
        RequestEntity<Product> productRequestEntity = productService.listOne(id);
        Product product = productRequestEntity.getData();


        int stock = product.getProductStock();
        //更新库存
        if (stock >= orderRequestDto.getCount()) {
            stock -= orderRequestDto.getCount();
            product.setProductStock(stock);
            productService.modifyStock(product);
        }
        //计算金钱
        BigDecimal total = total(product, orderRequestDto);
        //更新订单详情信息
        OrderItem orderItem = addOrderItem(ly, orderRequestDto, product);
        int insert = orderItemMapper.insert(orderItem);
        if (insert == 0) {
            throw new ServiceException(RequestCode.ERROR);
        }


        //更新订单信息
        Order order = addOrder(ly, orderRequestDto, total);
        int insert1 = orderMapper.insert(order);
        if (insert1 == 0) {
            throw new ServiceException(RequestCode.ERROR);
        }
        //更新订单地址信息
        OrderAddress orderAddress = addOrderAddress(orderRequestDto, total, order);
        int insert2 = orderAddressMapper.insert(orderAddress);
        if (insert2 == 0) {
            throw new ServiceException(RequestCode.ERROR);
        }
        //返回支付数据
        orderDto.setOrderNo(ly);
        orderDto.setTotal(total);
        orderDto.setSubject("磊爷商城");
        return orderDto;
    }

    /**
     * 更新订单信息
     *
     * @param ly
     * @param orderRequestDto
     * @param total
     * @return
     */
    public Order addOrder(String ly, OrderRequestDto orderRequestDto, BigDecimal total) {
        Order order = new Order();
        order.setOrderNo(ly);
        order.setTotal(total);
        order.setMemberId(orderRequestDto.getMemberId());
        return order;
    }

    /**
     * 更新订单详情
     *
     * @return
     */
    public OrderItem addOrderItem(String ly, OrderRequestDto orderRequestDto, Product product) {
        OrderItem orderItem = new OrderItem();
        orderItem.setMemberId(orderRequestDto.getMemberId());
        orderItem.setOrderNo(ly);
        orderItem.setProductName(product.getProductName());
        orderItem.setProductPic(product.getProductImg());
        orderItem.setProductPrice(product.getNewPrice());
        orderItem.setProductQuantity(product.getProductStock());
        return orderItem;
    }

    /**
     * 更新订单地址信息
     *
     * @param orderRequestDto
     * @param total
     * @param order
     * @return
     */
    public OrderAddress addOrderAddress(OrderRequestDto orderRequestDto, BigDecimal total, Order order) {
        OrderAddress orderAddress = new OrderAddress();
        orderAddress.setAddress(orderRequestDto.getAddress());
        orderAddress.setOrderId(order.getOrderId());
        orderAddress.setPhone(orderRequestDto.getPhone());
        return orderAddress;
    }

    /**
     * 计算价格,考虑红包和优惠券
     *
     * @param product
     * @param orderRequestDto
     * @return
     */
    public BigDecimal total(Product product, OrderRequestDto orderRequestDto) {
        //初始金额计算
        BigDecimal total = new BigDecimal(0);
        BigDecimal price = product.getNewPrice();
        BigDecimal count = new BigDecimal(orderRequestDto.getCount());
        BigDecimal multiply = price.multiply(count);
        total = total.add(multiply);
        //会员积分兑换
        Integer memberId = orderRequestDto.getMemberId();
        RequestEntity<PointsTotal> total1 = pointsService.total(memberId);
        Integer total2 = total1.getData().getTotal();
        if (total2 >= 10) {
            BigDecimal discount = new BigDecimal(total2 / 10);
            total = total.subtract(discount);
            rocketMQTemplate.asyncSendOrderly(topicCode, orderRequestDto.getMemberId(), "memberId", new DefaultSendCallBack());

            //增加一个更新数据库的操作
        }
        //优惠券兑换,如果有优惠券会要求前端发送discount_limit字段的数据
        //这里不可以叠加使用优惠券
        //前端来判断需不需要优惠券

        RequestEntity<List<DiscountDto>> list = discountService.list(memberId, 1, 10);
        List<DiscountDto> data = list.getData();
        //前端发送过来用户选择的优惠券
        List<Integer> disId = orderRequestDto.getDisId();
        for (DiscountDto discountDto : data) {
            for (Integer integer : disId) {
                Integer id = discountDto.getId();
                if (id == integer) {

                    BigDecimal discountMoney = discountDto.getDiscountMoney();
                    if (discountDto.getDiscountDes() == 1) {
                        //数据库存放小数,而不是整数
                        //输出百分数
                        //NumberFormat numberFormat = NumberFormat.getPercentInstance();
                        //String format = numberFormat.format(discountMoney);
                        total = total.multiply(discountMoney);
                        rocketMQTemplate.asyncSendOrderly(topicCode, orderRequestDto.getDisId(), "disId", new DefaultSendCallBack());

                    }
                    if (discountDto.getDiscountDes() == 2) {
                        //兑换券
                        total = total.subtract(discountMoney);
                        rocketMQTemplate.asyncSendOrderly(topicCode, orderRequestDto.getDisId(), "disId", new DefaultSendCallBack());

                    }
                    if (discountDto.getDiscountDes() == 3) {
                        //红包
                        total = total.subtract(discountMoney);
                        rocketMQTemplate.asyncSendOrderly(topicCode, orderRequestDto.getDisId(), "disId", new DefaultSendCallBack());

                    }

                }
            }
        }

//        data.forEach(requestDiscountDto -> {
//            disId.forEach(integer -> {
//                Integer id = requestDiscountDto.getId();
//                if (id == integer) {
//                    BigDecimal discountMoney = requestDiscountDto.getDiscountMoney();
//                    if (requestDiscountDto.getDiscountDes() == 1) {
//                        //数据库存放小数,而不是整数
//                        //输出百分数
//                        //NumberFormat numberFormat = NumberFormat.getPercentInstance();
//                        //String format = numberFormat.format(discountMoney);
//                        total.multiply(discountMoney);
//
//                    } else if (requestDiscountDto.getDiscountDes() == 2) {
//                        //兑换券
//                        total.subtract(discountMoney);
//                    } else if (requestDiscountDto.getDiscountDes() == 3) {
//                        //红包
//                        total.subtract(discountMoney);
//                    }
//
//                }
//            });
//
//
//    });

        return total;

    }
}
