package zhulei.JianzhiOffer.No69_圆圈中最后剩下的数字;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zl
 * @Date: 2022/8/8 18:57
 * @Description:
 *      0, 1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
 *      例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 */
public class Solution {

    @Test
    void fun() {
        System.out.println(lastRemaining(10, 17));
        System.out.println(cycleMethod(10, 17));
        System.out.println(cycleMethodPlus(10, 17));
    }


    /**
     * 约瑟夫环问题 - 数学解法
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining(int n, int m) {
        int res = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            res = (res + m) % i;
        }
        return res;
    }

    /**
     * 暴力求解，超出时限
     * @param n
     * @param m
     * @return
     */
    public int cycleMethod(int n, int m) {
        List<Integer> cycle = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            cycle.add(i);
        }
        int res = 0, index = 1;
        for (int i = cycle.size() - 1; i >= 0; i--, index++) {
            if (cycle.size() == 1) {
                res = cycle.get(0);
            }
            if (index == m) {
                cycle.remove(cycle.get(i));
                index = 0;
            }
            if (i == 0) {
                i = cycle.size();
            }
        }

        return res;
    }

    /**
     * 针对前面暴力求解发的优化
     * @param n
     * @param m
     * @return
     */
    public int cycleMethodPlus(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while (n > 1) {
            // 通过取余来确定被删除的元素
            index = (index + m - 1) % n;
            list.remove(index);
            n--;
        }
        return list.get(0);
    }
}
