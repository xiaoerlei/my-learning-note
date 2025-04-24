package zhulei.DesignMode.Strategy;

import javafx.util.Pair;

import java.math.BigDecimal;

/**
 * @Author: zl
 * @Date: 2022/8/9 23:19
 * @Description: 满减策略
 */
public class ReductionStrategy extends AbtractStrategy {

    private StrategyDetail detail;

    public ReductionStrategy(StrategyDetail detail) {
        this.detail = detail;
    }

    @Override
    double chooseStrategy(double curCost) {
        Pair<Integer, Integer> reduction = detail.getReduction();
        BigDecimal aimCost = new BigDecimal(Double.toString(reduction.getKey()));
        BigDecimal reductionCost = new BigDecimal(Double.toString(reduction.getValue()));
        BigDecimal cost = new BigDecimal(Double.toString(curCost));
        return cost.compareTo(aimCost) >= 0 ? cost.subtract(reductionCost).doubleValue() : curCost;
    }
}
