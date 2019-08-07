package zhulei.LeetCode.No343_整数拆分;

import org.junit.jupiter.api.Test;

/**
 * @Author: zl
 * @Date: 2019/8/5 20:45
 * @Description: 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 *              输入: 2                               输入: 10
 *              输出: 1                               输出: 36
 *              解释: 2 = 1 + 1, 1 × 1 = 1。          解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 *
 *       假设 n 不小于 2 且不大于 58。
 */
public class Solution {

    @Test
    public void function(){
        System.out.println(integerBreak(10));
    }

    // 动态规划
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            // 每次循环保留最大的dp[i]，这样下次计算最新的dp的时候，就得到了保存的最大子集结果
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }

        return dp[n];
    }

    // 记忆化搜索。超时
    public int memoMethod(int n) {
        if(n == 1)
            return 1;

        int res = -1;
        for (int i = 1; i < n; i++) {
            res = Math.max(res, Math.max(i * (n - i), i * integerBreak(n - i)));
        }

        return res;
    }
}
