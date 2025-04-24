package zhulei.DesignMode.Decoration;

/**
 * @Author: zl
 * @Date: 2022/8/12 21:03
 * @Description:
 */
public class Noodles extends Food {

    @Override
    public int cost() {
        return 5;
    }

    @Override
    public String description() {
        return "面条";
    }
}
