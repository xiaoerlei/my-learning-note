package zhulei.JavaNote.Java多线程.线程创建的几种方式.使用Callable和Future;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Author: zl
 * @Date: 2019/9/11 10:41
 * @Description:
 */
public class Main {

    public static void main(String[] args){

        FutureTask<String> future = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                for(int i = 0; i < 10; i++){
                    System.out.println(Thread.currentThread().getName() + "的循环变量i的值 ：" + i);
                }
                return "hahah";
            }
        });

        System.out.println(Thread.currentThread().getName());
        // 实质上还是以Callable对象来创建并启动线程
        new Thread(future, "有返回值的线程").start();
        try {
            // get()方法会阻塞，直到子线程执行结束才返回
            System.out.println("子线程的返回值：" + future.get());
        } catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
