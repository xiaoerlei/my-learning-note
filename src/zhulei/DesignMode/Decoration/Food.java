package zhulei.DesignMode.Decoration;

/**
 * @Author: zl
 * @Date: 2022/8/12 21:03
 * @Description:
 */
public abstract class Food {

    /**
     * 计算一顿饭对应消费金额
     * @return
     */
    public abstract int cost();

    /**
     * 描述信息
     * @return
     */
    public abstract String description();
}
