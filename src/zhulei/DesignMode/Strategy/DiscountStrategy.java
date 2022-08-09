package zhulei.DesignMode.Strategy;

import java.math.BigDecimal;

/**
 * @Author: zl
 * @Date: 2022/8/9 23:18
 * @Description: 打折策略
 */
public class DiscountStrategy extends AbtractStrategy {

    private StrategyDetail detail;

    public DiscountStrategy(StrategyDetail detail) {
        this.detail = detail;
    }

    @Override
    double chooseStrategy(double curCost) {
        BigDecimal discount = new BigDecimal(Double.toString(detail.getDiscount()));
        BigDecimal cost = new BigDecimal(Double.toString(curCost));
        return discount.divide(new BigDecimal(10), 0).multiply(cost).doubleValue();
    }
}
