package zhulei.JavaNote.Java多线程.线程创建的几种方式.继承Thread类;

/**
 * @Author: zl
 * @Date: 2019/9/11 10:27
 * @Description:
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("通过继承Thread类，线程执行方法...");
    }
}



