package zhulei.JavaNote.Java多线程.线程创建的几种方式.实现Runnable接口;

/**
 * @Author: zl
 * @Date: 2019/9/11 10:32
 * @Description:
 */
public class MyThread implements Runnable{

    @Override
    public void run() {
        System.out.println("通过实现Runnable接口，线程执行方法...");
    }

}
