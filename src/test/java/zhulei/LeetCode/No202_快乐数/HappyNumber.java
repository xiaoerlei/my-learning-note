package zhulei.LeetCode.No202_快乐数;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: zl
 * @Date: 2019/5/5 21:06
 * @Description: 一个“快乐数”定义为：
 *              对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
 *              然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。
 *              如果可以变为 1，那么这个数就是快乐数。
 */
public class HappyNumber {

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    private static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        // 如果set中出现了重复元素，则说明出现了死循环。所以set的作用是用来跳出循环
        while (n != 1 && !set.contains(n)){
            set.add(n);
            int sum = 0;
            while (n != 0){
                sum += Math.pow(n % 10, 2);
                n /= 10;
            }
            n = sum;    // 每次都再一次把sum的值赋给n
        }
        return 1 == n;
    }
}
