package com.qfedu.sentinel.fallback;

import com.qfedu.sentinel.domain.AddressDto;
import com.qfedu.sentinel.service.SentinelService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description:
 * @author: zxl
 * @Data:2020/8/7
 */

/**
 * 直接返回客户端
 */
@Component
public class AddressFallBackService implements SentinelService {
    @Override
    public List<AddressDto> list(int uid, int page, int size) {
        return null;
    }
}
