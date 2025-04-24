package zhulei.DesignMode.Proxy.StaticProxy;

/**
 * @Author: zl
 * @Date: 2019/4/2 17:27
 * @Description:
 */
public class CountImpl implements Count {

    @Override
    public void queryCount() {
        System.out.println("查看账户...");
    }

    @Override
    public void updateCount() {
        System.out.println("修改账户...");
    }
}
