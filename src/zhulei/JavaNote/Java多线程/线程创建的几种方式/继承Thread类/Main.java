package zhulei.JavaNote.Java多线程.线程创建的几种方式.继承Thread类;

/**
 * @Author: zl
 * @Date: 2019/9/11 10:28
 * @Description: 通过继承Thread类来创建并启动多线程的一般步骤如下
 *
 *      1. 定义Thread类的子类，并重写该类的run()方法，该方法的方法体就是线程需要完成的任务，run()方法也称为线程执行体。
 *      2. 创建Thread子类的实例，也就是创建了线程对象
 *      3. 启动线程，即调用线程的start()方法
 */
public class Main {

    public static void main(String[] args) {
        Thread thread = new MyThread();
        thread.start();
        System.out.println("主线程方法...");
    }
}
