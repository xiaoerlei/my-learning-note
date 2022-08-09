package zhulei.DesignMode.Strategy;

/**
 * @Author: zl
 * @Date: 2022/8/9 23:03
 * @Description:
 */
public abstract class AbtractStrategy {

    /**
     * 选择策略
     * @param curCost 当前消费
     * @return
     */
    abstract double chooseStrategy(double curCost);
}
