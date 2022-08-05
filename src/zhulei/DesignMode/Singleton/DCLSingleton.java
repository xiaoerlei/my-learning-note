package zhulei.DesignMode.Singleton;

/**
 * @Author: zl
 * @Date: 2019/8/18 18:35
 * @Description: Double Check Lock（DCL）双重校验锁
 *
 *          既能在需要时才初始化单例，又能保证线程安全，且单例对象初始化后调用getInstance不进行同步锁
 *          双重检查锁机制很好的解决了懒加载单例模式的效率问题和线程安全问题。所以，这也是我们最常用到的方式。
 *
 *          在JDK1.5之后，双重检查锁定才能够正常达到单例效果
 */
public class DCLSingleton {

    // 懒汉模式的改进，但仍然存在隐患
//    private static DCLSingleton instance = null;

    // 隐患解决：加上volatile关键字，这样就可以保证instance对象每次都是从主内存中读取的
    private static volatile DCLSingleton instance = null;

    private DCLSingleton() {
    }

    public static DCLSingleton getInstance() {
        // 第一层判断主要是为了避免不必要的同步
        if (instance == null) {

            synchronized (DCLSingleton.class) {
                // 第二层判空是为了在null情况下创建实例
                if (instance == null) {
                    instance = new DCLSingleton();
                }
            }

        }
        return instance;
    }
}
