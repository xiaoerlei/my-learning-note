package zhulei.DesignMode.代理模式.动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: zl
 * @Date: 2019/4/2 18:19
 * @Description: 实现 调用管理接口InvocationHandler  创建动态代理类
 *
 *              Proxy类与普通类的唯一区别就是其字节码是由 JVM 在运行时动态生成的而非预存在于任何一个 .class 文件中
 */

public class BookFacadeProxy implements InvocationHandler {
    private Object target;  //这其实业务实现类对象，用来调用具体的业务方法
    /**
     * 绑定业务对象并返回一个代理类
     */
    public Object bind(Object target) {
        this.target = target;  // 接收业务实现类对象参数

        // 通过反射机制，创建一个代理类对象实例并返回。用户进行方法调用时使用
        // 创建代理对象时，需要传递该业务类的类加载器（用来获取业务实现类的元数据，在包装方法是调用真正的业务方法）、接口、handler实现类
        // 每次生成动态代理类对象时都需要指定一个类装载器对象：newProxyInstance()方法第一个参数
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this); }

    /**
     * 包装调用方法：进行预处理、调用后处理
     *
     * proxy:　　指代我们所代理的那个真实对象
     * method:　　指代的是我们所要调用真实对象的某个方法的Method对象
     * args:　　指代的是调用真实对象某个方法时接受的参数
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;

        System.out.println("预处理操作——————");
        // 调用真正的业务方法
        result = method.invoke(target, args);

        System.out.println("调用后处理——————");
        return result;
    }
}

/**
 * public static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)
 *      throws IllegalArgumentException
 *
 * loader:　一个ClassLoader对象，定义了由哪个ClassLoader对象来对生成的代理对象进行加载
 * interfaces:　一个Interface对象的数组，表示的是我将要给我需要代理的对象提供一组什么接口，如果我提供了一组接口给它，
 *          那么这个代理对象就宣称实现了该接口(多态)，这样我就能调用这组接口中的方法了
 * h:　一个InvocationHandler对象，表示的是当我这个动态代理对象在调用方法的时候，会关联到哪一个InvocationHandler对象上
 */