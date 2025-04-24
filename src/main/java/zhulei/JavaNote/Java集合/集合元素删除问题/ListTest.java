package zhulei.JavaNote.Java集合.集合元素删除问题;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: zl
 * @Date: 2022/8/15 18:21
 * @Description: 测试ConcurrentModificationException出现的情况、原因及解决办法
 */
public class ListTest {

    /**
     * 如果使用了list.remove()方法，就会将modCount+1，而后再进行checkForComodification()方法时，
     * 就会发现modCount与expectedModCount不相等，就会抛出异常 ConcurrentModificationException
     *
     * 如果使用了iterator.remove()方法，可以发现，它将expectedModCount进行了更新
     * 即expectedModCount = modCount；expectedModCount与modCount相等，就不会报错；
     *
     * 此外，还可以使用
     *
     * 补充，Iterator来删除集合中某一个不满足条件的元素时，首先需要使用next方法迭代出集合中的元素，然后才能调用remove方法，否则集合可能会因为对同一个Iterator remove而抛异常
     */

    public static void main(String[] args) {
        removeTest1();
        removeTest2();
    }

    static void removeTest1() {
        List<Integer> list = new ArrayList<Integer>() {
            {
                add(1);
                add(2);
                add(3);
            }
        };
        list.add(5);
        // -----------------错误处理方式-----------------
        List<Integer> demo1 = new ArrayList<>(list);
        try {
            for (Integer num : demo1) {
                if (num.equals(2)) {
                    demo1.remove(num);
                }
            }
            System.out.println(demo1);
        } catch (Exception e) {
            System.out.println("ConcurrentModificationException");
        }
        // -----------------正确处理方式-----------------
        List<Integer> demo2 = new ArrayList<>(list);
        // method1:iterator.next()+iterator.remove()在单线程下安全删除
        try {
            Iterator<Integer> iterator = demo2.iterator();
            while (iterator.hasNext()) {
                Integer num = iterator.next();
                if (num.equals(2)) {
                    iterator.remove();
                }
            }
            demo2.removeIf(num -> num.equals(5));
            System.out.println(demo2);
        } catch (Exception e) {
            System.out.println("ConcurrentModificationException");
        }
        // CopyOnWriteArrayList来安全删除，多线程情况下也依然安全（多线程下非ArrayList中也可以对iterator.next()加锁的方式来删除）
        CopyOnWriteArrayList<Integer> safeList = new CopyOnWriteArrayList<>(list);
        for (Integer num : safeList) {
            if (num.equals(1) || num.equals(5)) {
                safeList.remove(num);
            }
        }
        System.out.println(safeList);
        // -----------------补充问题-----------------
        List<Integer> demo3 = new ArrayList<>(list);
        try {
            int index = 0;
            Iterator<Integer> iterator = demo3.iterator();
            while (iterator.hasNext()) {
                iterator.next();    // 这一行虽然没有用到返回值，但是必须得加上
                if (index++ % 2 == 1) {
                    iterator.remove();
                }
            }
            System.out.println(demo3);
        } catch (Exception e) {
            System.out.println("IllegalStateException");
        }
    }

    /**
     * 在一般条件判断删除得情况下，尽量通过倒序删除的方式，倒序删除数组下标一般都会随着删除元素的减少而减少
     * 正序删除一般情况下容易发生数组越界
     * 此外，由于正常的for循环是调用list.get()方法来取值的，非foreach语法糖，所以不会出现ConcurrentModificationException
     */
    static void removeTest2() {
        List<String> list = new ArrayList<String>() {
            {
                add("a");
                add("b");
                add("c");
                add("d");
                add("e");
            }
        };
        list.add("f");

        int len = list.size();
        // -----------------正序删除抛异常-----------------
        try {
            List<String> demo1 = new ArrayList<>(list);
            int seq = 0;
            for (int i = 0; i < len; i++) {
                // 这里需要额外判断集合长度，避免越界
                if (seq++ % 2 == 1 && i < demo1.size()) {
                    demo1.remove(demo1.get(i));
                }
            }
            System.out.println(demo1);
        } catch (Exception e) {
            System.out.println("IndexOutOfBoundException");
        }
        // -----------------倒序删除不抛异常-----------------
        try {
            List<String> demo2 = new ArrayList<>(list);
            int rev = 0;
            for (int i = len - 1; i >= 0; i--) {
                if (rev++ % 2 == 1) {
                    demo2.remove(demo2.get(i));
                }
            }
            System.out.println(demo2);
        } catch (Exception e) {
            System.out.println("IndexOutOfBoundException");
        }

    }

}
