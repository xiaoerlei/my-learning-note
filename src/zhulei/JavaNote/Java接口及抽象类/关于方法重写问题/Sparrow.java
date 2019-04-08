package zhulei.JavaNote.Java接口及抽象类.关于方法重写问题;

/**
 * @Author: zl
 * @Date: 2019/4/2 17:02
 * @Description: 因为Sparrow继承于Bird，而Bird又实现于Behavior接口。
 *          所以Sparrow要实现Bird中未实现的方法，并可以选择性的覆盖父类抽象类Bird的方法，比如fly()。
 *          同时也还需要实现父类Bird中的抽象方法
 */
public class Sparrow extends Bird {

    @Override
    public void fly() {
        super.fly();
    }

    @Override
    public void sleep() {
        super.sleep();
        System.out.println("洗洗睡吧");
    }

    @Override
    public void sing() {
        System.out.println("lalalalala");
    }

    @Override
    public void jump() {
        System.out.println("跳啊跳啊跳");
    }

    public void dance(){
        System.out.println("其实我不会跳舞");
    }
}
