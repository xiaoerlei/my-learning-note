package zhulei.LeetCode.No279_完全平方数;

import org.junit.jupiter.api.Test;

/**
 * @Author: zl
 * @Date: 2019/8/5 21:54
 * @Description: 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 *          输入: n = 12                              输入: n = 13
 *          输出: 3                                   输出: 2
 *          解释: 12 = 4 + 4 + 4.                     解释: 13 = 4 + 9.
 */
public class Solution {

    @Test
    public void function(){
        System.out.println(numSquares(13));
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;  // 默认最坏情况，每次都+1
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }
}
