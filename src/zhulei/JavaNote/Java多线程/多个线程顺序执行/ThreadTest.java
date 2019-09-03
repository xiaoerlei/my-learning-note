package zhulei.JavaNote.Java多线程.多个线程顺序执行;

/**
 * 多线程顺序执行
 *
 * join方法实现：
 *      join的本质还是调用的wait方法
 *      join方法可以提交过期时间，也就是在执行到达预定时间后，执行方式将继续以并行的方式执行
 */
public class ThreadTest {

    // 先执行main线程，打印”Hello“，然后利用join方法，依次执行A、B和C三个线程
    public static void main(String[] args) {
        String str = "Hello";
        System.out.println(str);

        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.print("_A");
            }
        });

        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.print("_B");
                try {
                    A.join(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread C = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    B.join(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print("_C");
            }
        });

        A.start();
        B.start();
        C.start();

    }

}
