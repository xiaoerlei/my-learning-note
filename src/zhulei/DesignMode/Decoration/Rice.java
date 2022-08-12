package zhulei.DesignMode.Decoration;

/**
 * @Author: zl
 * @Date: 2022/8/12 21:37
 * @Description:
 */
public class Rice extends Food {

    @Override
    public int cost() {
        return 7;
    }

    @Override
    public String description() {
        return "炒饭";
    }
}
