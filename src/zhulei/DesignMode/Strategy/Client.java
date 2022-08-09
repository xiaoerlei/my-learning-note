package zhulei.DesignMode.Strategy;

import org.junit.jupiter.api.Test;

/**
 * @Author: zl
 * @Date: 2022/8/9 22:57
 * @Description:
 */
public class Client {

    @Test
    void fun() {
        StrategyContext strategy1 = new StrategyContext(StrategyEnum.DISCOUNT_7);
        System.out.println(strategy1.getTotalCost(500));

        StrategyContext strategy2 = new StrategyContext(StrategyEnum.REDUCTION_500_40);
        System.out.println(strategy2.getTotalCost(500));
    }

}
