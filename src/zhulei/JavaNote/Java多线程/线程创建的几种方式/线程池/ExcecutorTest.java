package zhulei.JavaNote.Java多线程.线程创建的几种方式.线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: zl
 * @Date: 2019/9/11 10:57
 * @Description: 通过Executors的以上四个静态工厂方法获得 ExecutorService实例，而后调用该实例的execute（Runnable command）方法即可。
 *          一旦Runnable任务传递到execute（）方法，该方法便会自动在一个线程上
 */
public class ExcecutorTest {

    public static void main(String[] args){
        ExecutorService executorService = Executors.newCachedThreadPool();
//      ExecutorService executorService = Executors.newFixedThreadPool(5);
//      ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 1; i <= 5; i++){
            executorService.execute(new MyThread());
            System.out.println("线程 " + i + " 被调用了");
        }
        executorService.shutdown();
    }
}
