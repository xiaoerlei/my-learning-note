package zhulei.DesignMode.单例模式;

/**
 * @Author: zl
 * @Date: 2019/8/18 18:44
 * @Description: 枚举单例
 *
 *        默认枚举实例的创建时线程安全的（防止反序列化重新创建新的对象），并且在任何情况下都是一个单例
 */
public enum EnumSingleton {

    INSTANCE;

    public void doSomething() {

    }
}
