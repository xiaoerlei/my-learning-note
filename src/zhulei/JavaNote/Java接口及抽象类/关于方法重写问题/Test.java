package zhulei.JavaNote.Java接口及抽象类.关于方法重写问题;

/**
 * @Author: zl
 * @Date: 2019/4/2 16:14
 * @Description:
 */
public class Test {

    public static void main(String[] args) {

        Sparrow s = new Sparrow();
        s.fly();    // 子类没有fly具体方法实现，这里是调用父类的方法实现
        s.sleep();
        s.sing();
        s.jump();
        s.dance();

        System.out.println("-------------------");

        Bird b = new Sparrow();
        b.fly();
        b.sleep();
        b.sing();
        b.jump();
        ((Sparrow) b).dance(); // 父类引用指向子类实例，是不能调用子类有而父类没有的方法。除非进行强制类型转换
    }
}
