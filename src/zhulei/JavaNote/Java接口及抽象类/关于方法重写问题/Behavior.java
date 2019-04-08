package zhulei.JavaNote.Java接口及抽象类.关于方法重写问题;

/**
 * @Author: zl
 * @Date: 2019/4/2 15:53
 * @Description: 接口内的方法，只能提供公共访问的抽象方法。
 */

/*
    为什么接口中可以不需要定义public等修饰符？

    答：
 */
public interface Behavior {

    public static final int size = 5;

    public abstract void eat();

    void jump();

    void fly();

}
