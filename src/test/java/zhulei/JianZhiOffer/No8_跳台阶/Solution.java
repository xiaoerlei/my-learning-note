package zhulei.JianZhiOffer.No8_跳台阶;

/**
 * @Author: zl
 * @Date: 2019/5/25 14:38
 * @Description: 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(JumpFloor(4));

        System.out.println(otherSolution(4));
    }

    // 本质上其实也就是一个斐波那契数列
    /*
        当只有一级台阶时：只有1 一种情况
        当有两级台阶时：有 1 和 2 两种情况
        当有三级台阶时：有1、1、1和1、2和2、1 三种情况
        当有四级台阶时：有5种情况
        。。。
        以此类推，得到一个斐波那契数列
     */
    public static int JumpFloor(int target) {
        if(target == 1)
            return 1;

        if(target == 2)
            return 2;

        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }

    // 非递归解法
    public static int otherSolution(int target) {
        if(target <= 2)
            return target;

        int result = 1;
        int fun1 = 1, fun2 = 2;
        // 根据通项的规律。来进行迭代
        for (int i = 2; i < target; i++) {
            result = fun1 + fun2;
            fun1 = fun2;
            fun2 = result;
        }

        return result;
    }
}
