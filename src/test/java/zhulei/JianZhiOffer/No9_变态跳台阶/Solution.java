package zhulei.JianZhiOffer.No9_变态跳台阶;

import java.util.Arrays;

/**
 * @Author: zl
 * @Date: 2019/5/25 15:17
 * @Description: 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(JumpFloorII(5));

        System.out.println(mathSolution(5));

        System.out.println(otherSolution(5));
    }

    // 动态规划的方式来做
    public static int JumpFloorII(int target) {
        int[] dp = new int[target];
        Arrays.fill(dp, 1);
        for (int i = 1; i < target; i++)
            for (int j = 0; j < i; j++)
                dp[i] += dp[j];
        return dp[target - 1];
    }

    /*
        根据题目能得到通项公式：f(n-1) = f(n-2) + f(n-3) + ... + f(0)
        所以，就有 f(n) = f(n-1) + f(n-2) + ... + f(0)
        两式合并得到：f(n) - f(n-1) = f(n-1)
        所以就有 f(n) = 2 * f(n-1)
        即，一共是有2的2-1次幂种跳法
     */
    public static int mathSolution(int target) {
        return (int) Math.pow(2, target - 1);
    }

    // 当然，也可以递归的方式这样来写
    public static int otherSolution(int target) {
        if(target == 1)
            return 1;
        return 2 * otherSolution(target - 1);
    }
}
