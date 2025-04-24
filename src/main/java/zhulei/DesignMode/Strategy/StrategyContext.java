package zhulei.DesignMode.Strategy;

import javafx.util.Pair;

/**
 * @Author: zl
 * @Date: 2022/8/9 23:01
 * @Description:
 */
public class StrategyContext {

    private AbtractStrategy strategy;

    /**
     * 自定义策略
     * @param strategy
     */
    public StrategyContext(AbtractStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 结合工厂模式来选择策略
     * @param strategyType
     */
    public StrategyContext(StrategyEnum strategyType) {
        switch (strategyType.getType()) {
            case 1:
                strategy = new NormalStrategy();
                break;
            case 11:
                strategy = new DiscountStrategy(new StrategyDetail(7, null));
                break;
            case 12:
                strategy = new DiscountStrategy(new StrategyDetail(8, null));
                break;
            case 21:
                strategy = new ReductionStrategy(new StrategyDetail(10, new Pair<>(300, 20)));
                break;
            case 22:
                strategy = new ReductionStrategy(new StrategyDetail(10, new Pair<>(500, 40)));
                break;
            default:
                System.out.println("无效策略");
                break;
        }

    }

    /**
     * 返回最终消费金额
     * @param curCost
     * @return
     */
    public double getTotalCost(double curCost) {
        return strategy.chooseStrategy(curCost);
    }
}
