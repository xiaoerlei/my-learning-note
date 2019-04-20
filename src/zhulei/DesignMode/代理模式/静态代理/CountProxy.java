package zhulei.DesignMode.代理模式.静态代理;

/**
 * @Author: zl
 * @Date: 2019/4/2 17:28
 * @Description:
 */
public class CountProxy implements Count {

    private Count count;

    public CountProxy(Count count){
        this.count = count;
    }

    @Override
    public void queryCount() {
        System.out.println("查询账户的预处理——————");
        // 调用真正的查询账户方法
        count.queryCount();
        System.out.println("查询账户之后————————");
    }

    @Override
    public void updateCount() {
        System.out.println("修改账户之前的预处理——————");
        // 调用真正的修改账户操作
        count.updateCount();
        System.out.println("修改账户之后——————————");
    }
}
