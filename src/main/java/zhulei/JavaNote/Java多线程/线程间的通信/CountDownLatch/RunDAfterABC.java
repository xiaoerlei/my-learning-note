package zhulei.JavaNote.Java多线程.线程间的通信.CountDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: zl
 * @Date: 2019/4/26 17:07
 * @Description: 线程A B C 全部执行完成后，最后再再执行线程 D
 *          解决思路：
 *                   1、创建一个计数器(counter), 并设置初始值: CountdownLatch countDownLatch = new CountDownLatch(3);
 *                   2、需要等待的线程, 调用 countDownLatch.await() 方法进入等待状态, 直到 count 值变成0为止;
 *                   3、其他线程调用 countDownLatch.countDown() 来将 count 值减小;
 *                   4、当其他线程调用 countDown() 将 count 值减小为0, 等待线程中的 countDownLatch.await() 方法将立即返回, 那么这个线程也就可以继续执行后续的代码
 *
 *          注：CountDownLatch可以用来计数, 但计数完成后, 只会有一个线程的 await() 方法得到响应, 所以不太适合多个线程同时等待的情况.
 */
public class RunDAfterABC {

    public static void main(String[] args) {
        final CountDownLatch countDownLatch = new CountDownLatch(3);
        Thread D = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("D 线程等待通知中...... ");
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("其他线程全部执行完成, D 线程开始执行...");
            }
        });
        D.start();

        for (char threadName = 'A'; threadName <= 'C'; threadName++) {
            final String tName = String.valueOf(threadName);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(tName + " 线程正在执行...");
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(tName + " 线程执行完毕");
                    countDownLatch.countDown();
                }
            }).start();
        }
    }
}
