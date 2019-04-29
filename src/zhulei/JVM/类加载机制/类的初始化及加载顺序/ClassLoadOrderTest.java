package zhulei.JVM.类加载机制.类的初始化及加载顺序;

/**
 * @Author: zl
 * @Date: 2019/4/25 19:14
 * @Description: 描述类加载的顺序
 *              对于通过子类来调用父类的成员变量，则不会触发子类的初始化
 *              因为对于静态字段，只有直接定义这个字段的类才会被初始化，因此通过其子类来引用父类中定义的静态字段，只会触发父类的初始化而不会触发子类的初始化
 *
 *              注：通过数组定义来引用类，不会触发此类的初始化
 */
public class ClassLoadOrderTest {

    public static void main(String[] args) {
        System.out.println(SubClass.value);
    }

}

class SSClass{
    static {
        System.out.println("SSClass.....");
    }
}

class SuperClass extends SSClass{
    static {
        System.out.println("SuperClass.....");
    }

    public static int value = 123;

    public SuperClass(){
        System.out.println("SuperClass init");
    }
}

class SubClass extends SuperClass{
    static {
        System.out.println("SubClass.....");
    }

    // 如果这里不注释，则会对子类进行初始化
//    public static int value = 456;

    // 同样构造方法中的输出语句也没有打印出来，因为没有对子类进行实例化
    public SubClass(){
        System.out.println("SubClass init");
    }
}