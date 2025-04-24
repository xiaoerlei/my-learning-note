package zhulei.DesignMode.SimpleFactory;

import java.math.BigDecimal;

/**
 * @Author: zl
 * @Date: 2022/8/5 22:15
 * @Description:
 */
public class Div implements Operation {

    @Override
    public double getResult(double a, double b) {
        BigDecimal A = new BigDecimal(String.valueOf(a));
        BigDecimal B = new BigDecimal(String.valueOf(b));
        return A.divide(B, 2).doubleValue();
    }
}
