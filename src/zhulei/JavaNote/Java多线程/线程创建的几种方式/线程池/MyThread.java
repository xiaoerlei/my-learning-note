package zhulei.JavaNote.Java多线程.线程创建的几种方式.线程池;

/**
 * @Author: zl
 * @Date: 2019/9/11 10:59
 * @Description:
 */
public class MyThread implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

}
