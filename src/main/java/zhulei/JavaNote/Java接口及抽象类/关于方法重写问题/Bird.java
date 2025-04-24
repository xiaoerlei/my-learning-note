package zhulei.JavaNote.Java接口及抽象类.关于方法重写问题;

/**
 * @Author: zl
 * @Date: 2019/4/2 16:36
 * @Description:  Bird实现了Behavior接口，但是并没有实现Behavior中的所有方法
 *              因为Bird用abstract修饰，所以可以不用实现所有的方法，但非抽象类实现则需要实现接口的所有方法
 */
public abstract class Bird implements Behavior{

    @Override
    public void eat() {
    }

    @Override
    public void fly() {
        System.out.println("我飞起来了");
    }

    // 在抽象类中也可以重新定义抽象方法
    public abstract void sing();

    public void sleep() {
        System.out.println("好困，我要睡觉了");
    }
}
