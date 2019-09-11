package zhulei.JavaNote.Java多线程.线程创建的几种方式.实现Runnable接口;

/**
 * @Author: zl
 * @Date: 2019/9/11 10:33
 * @Description: 通过实现Runnable接口创建并启动线程一般步骤如下：
 *
 *          1. 定义Runnable接口的实现类，一样要重写run()方法，这个run（）方法和Thread中的run()方法一样是线程的执行体
 *          2. 创建Runnable实现类的实例，并用这个实例作为Thread的target来创建Thread对象，这个Thread对象才是真正的线程对象
 *          3. 第三部依然是通过调用线程对象的start()方法来启动线程
 */
public class Main {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread thread = new Thread(myThread);
        thread.start();
        System.out.println("主线程执行中...");
    }
}
