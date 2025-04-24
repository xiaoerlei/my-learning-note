package zhulei.DesignMode.Strategy;

/**
 * @Author: zl
 * @Date: 2022/8/9 22:57
 * @Description:
 */
public class Client {
    public static void main(String[] args) {
        StrategyContext strategy1 = new StrategyContext(StrategyEnum.DISCOUNT_7);
        System.out.println(strategy1.getTotalCost(500));

        StrategyContext strategy2 = new StrategyContext(StrategyEnum.REDUCTION_500_40);
        System.out.println(strategy2.getTotalCost(500));
    }

}
