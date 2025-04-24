package zhulei.JavaNote.Java多线程.两个线程交互执行.A线程和B线程按指定顺序交替执行;

/**
 * @Author: zl
 * @Date: 2019/4/26 16:39
 * @Description:    按照 A 打印1、然后 B 打印1,2,3, 再让A打印2、3的顺序打印
 *              1、首先创建一个对象锁: lock = new Object();
 *              2、线程 A 获取锁, 得到后先打印 1, 然后调用 lock.wait() 进入等待状态, 同时移交锁的控制权;
 *              3、线程 B 暂时不会执行打印, 需要等A调用lock.wait()释放锁之后, B 获得锁才开始执行打印;
 *              4、线程 B 打印出1、2、3, 然后调用lock.notify()方法来唤醒等待这个锁的线程(A);
 *              5、线程 A 被唤醒之后, 等待获得锁, 之后继续打印剩下的2和3.
 */

public class ThreadPrintTest {

    public static void main(String[] args) {
        final Object lock = new Object();
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(lock){
                    System.out.println("A 1");
                    try {
                        // Object # wait() 则是临时放弃锁, 进入沉睡, 必须有人唤醒(notify), 否则会睡死, 或者被超时打断.
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("A 2");
                    System.out.println("A 3");
                }
            }
        });

        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                // synchronized代码块结束, 会自动释放锁.
                synchronized(lock){
                    System.out.println("B 1");
                    System.out.println("B 2");
                    System.out.println("B 3");
                    // Object # notify() 只是唤醒某个线程, 并没有释放锁.
                    lock.notify();
                }
            }
        });

        A.start();
        B.start();
    }
}
