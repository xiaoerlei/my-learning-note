package zhulei.DesignMode.Singleton;

/**
 * @Author: zl
 * @Date: 2019/8/18 18:30
 * @Description: 懒汉式单例模式。声明一个静态对象，并且在用户第一次调用getInstance时进行初始化。
 *
 *          优点：只有在使用时才会实例化单例对象，在一定程度上节约了资源
 *          缺点：第一次加载时需要进行实例化，反应稍慢
 *
 *          问题：每次调用都会进行同步吗，造成不必要的同步开销。这种模式一般不建议使用。
 */
public class LazySingleton {

    // 在类加载时不创建实例，因此类加载熟读快，但运行时获取对象速度慢
    private static LazySingleton instance;

    private LazySingleton() {}

    // 静态、同步、公开访问
    // synchronized关键字保证了同步，在多线程情况下单例的唯一性。
    public static synchronized LazySingleton getInstance() {
        if(instance == null)
            return new LazySingleton();

        return instance;
    }
}
