package zhulei.DesignMode.Strategy;

/**
 * @Author: zl
 * @Date: 2022/8/9 23:20
 * @Description: 正常策略
 */
public class NormalStrategy extends AbtractStrategy {

    @Override
    double chooseStrategy(double curCost) {
        return curCost;
    }
}
