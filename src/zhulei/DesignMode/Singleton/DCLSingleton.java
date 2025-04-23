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

    /*
        隐患解决：加上volatile关键字，这样就可以保证instance对象每次都是从主内存中读取的
            线程1执行时，此时instance已经指向一块内存地址，不为null，但是对象还未完成初始化，
            此时CPU切换到线程2执行第一个if判断，结果为false，于是返回了一个不完整的对象
    */
    private static volatile DCLSingleton instance = null;

    private DCLSingleton() {
    }

    public static DCLSingleton getInstance() {
        // 第一层判断主要是为了避免不必要的同步和锁竞争，提高执行效率
        if (instance == null) {
            // 保证线程执行下面代码块的过程是原子的
            synchronized (DCLSingleton.class) {
                // 第二层判空是为了防止，在有可能会出现两个线程都经过了前面第一次检查，进而造成两次初始化。
                // 此前可能有两个线程同时跳过了第一次if判断，其中一个执行代码块儿，而第二个线程被阻塞在
                if (instance == null) {
                    instance = new DCLSingleton();
                }
            }

        }
        return instance;
    }
}
