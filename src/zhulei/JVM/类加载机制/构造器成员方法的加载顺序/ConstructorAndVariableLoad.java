package zhulei.JVM.类加载机制.构造器成员方法的加载顺序;

/**
 * @Author: zl
 * @Date: 2019/4/25 19:32
 * @Description:
 */
public class ConstructorAndVariableLoad {

    public static void main(String[] args) {
        staticFunction();
    }

    /**
     *  1、类的初始化阶段需要做是执行类构造器
     *      此时会进行对象的初始化，对象的初始化是先初始化成员变量再执行构造方法
     */
    static ConstructorAndVariableLoad cavl = new ConstructorAndVariableLoad();

    /**
     * 4、初始化类的静态成员变量
     */
    static {
        System.out.println("1");
    }

    /**
     *  2、对象初始化，首先初始化成员变量
     */
    {
        System.out.println("2");
    }

    /**
     *  3、然后初始化构造方法
     */
    ConstructorAndVariableLoad() {
        System.out.println("3");
        System.out.println("a = " + a + ", b = " + b + ", c = " + c);
    }

    /**
     * 5、最后初始化类的类方法
     */
    public static void staticFunction(){
        System.out.println("4");
    }

    int a = 110;    // 初始化对象成员变量的的值，并进行赋值操作
    static int b = 112;     // 静态成员变量，这里的准备阶段设置的是默认值，默认值为0
    static final int c = 120;   // 如果类变量是final，编译时javac将会为value生成ConstantValue属性，在准备阶段虚拟机就会根据ConstantValue的设置将变量设置为指定的值
}


/*
    笔记：
        Java中赋值顺序：
            1. 父类的静态变量赋值
            2. 自身的静态变量赋值
            3. 父类成员变量赋值
            4. 父类块赋值
            5. 父类构造函数赋值
            6. 自身成员变量赋值
            7. 自身块赋值
            8. 自身构造函数赋值
 */