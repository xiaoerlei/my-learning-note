package zhulei.JavaNote.Java多线程.两个线程交互执行.先打印线程A再打印线程B;

/**
 * @Author: zl
 * @Date: 2019/4/26 16:23
 * @Description:  主要使用到了join()方法：
 *                      当我们调用某个线程的这个方法时，这个方法会挂起调用线程，直到被调用线程结束执行，调用线程才会继续执行。
 */
public class ThreadPrintTest {

    public static void main(String[] args) {

        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                printNumber("A");
            }
        });

        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("B线程等待中...");

                try {
                    A.join();   // 等待线程A执行完成之后与当前线程“汇合”
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                printNumber("B");
            }
        });

        A.start();
        B.start();
    }

    // 打印函数，指定了打印的间隔和打印的次数
    private static void printNumber(String threadName) {
        int i = 0;
        while (i++ < 100) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadName + "print:" + i);
        }
    }
}
