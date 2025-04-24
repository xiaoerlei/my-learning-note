package zhulei.JavaNote.Java多线程.线程间的通信.CyclicBarrier;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author: zl
 * @Date: 2019/4/26 17:39
 * @Description:  用3个线程来模拟, A,B,C 线程各自准备, 等全部准备就绪, 同时开始运行
 */
public class RunABCWhenAllReady {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        final Random random = new Random();
        for (char runnerName = 'A'; runnerName <= 'C'; runnerName++) {
            final String rName = String.valueOf(runnerName);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    long prepareTime = random.nextInt(10000) + 100;
                    System.out.println(rName + " 需要的准备时间:" + prepareTime);
                    try {
                        Thread.sleep(prepareTime);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        System.out.println(rName + " 准备就绪, 等待其他线程... ");
                        cyclicBarrier.await(); // 当前线程准备就绪, 等待其他人的反馈
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(rName + " 开始运行"); // 所有线程一起开始
                }
            }).start();
        }
    }
}
