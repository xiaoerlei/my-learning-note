package zhulei.DesignMode.Singleton;

/**
 * @Author: zl
 * @Date: 2019/8/18 18:29
 * @Description: 饿汉式单例模式（在类加载时就完成了初始化，所以类加载较慢，但获取对象的速度快）
 */
public class EagerSingle {

    // 在类加载时就完成了初始化，所以类加载较慢，但获取对象的速度快
    private static EagerSingle single = new EagerSingle();//静态私有成员，已初始化

    private EagerSingle() {}

    // 静态，不用同步（类加载时已初始化，不会有多线程的问题）
    public static EagerSingle getInstance() {
        return single;
    }
}
