import java.text.NumberFormat;

/**
 * @Description:
 * @author: zxl
 * @Data:2020/8/9
 */
public class Test {
    public static void main(String[] args) {
        NumberFormat numberFormat = NumberFormat.getPercentInstance();
        System.out.println("-------------");
        System.out.println(numberFormat.format(0.8));

    }
}
