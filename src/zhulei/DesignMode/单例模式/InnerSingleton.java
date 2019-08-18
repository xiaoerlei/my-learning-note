package zhulei.DesignMode.单例模式;

/**
 * @Author: zl
 * @Date: 2019/8/18 18:39
 * @Description: 静态内部类单例模式
 *
 *      第一次调用getInstance方法会导致虚拟机加载InnerSingleton类，
 *      这种方法不仅能保证线程安全，也能够保证单例对象的唯一性，同时也延迟了单例的实例化，所以这也是一种推荐的单例模式实现方法
 */
public class InnerSingleton {

    private InnerSingleton() {}

    // 第一次加载InnerSingleton类时并不会初始化instance，只有在第一次调用getInstance方法时才会导致instance被初始化
    public static InnerSingleton getInstance() {
        return InnerSingletonHolder.instance;
    }

    /**
     * 静态内部类
     */
    private static class InnerSingletonHolder {
        private static final InnerSingleton instance = new InnerSingleton();
    }
}
