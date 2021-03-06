package zhulei.LeetCode.No309_最佳买卖股票时机含冷冻期;

import org.junit.jupiter.api.Test;

/**
 * @Author: zl
 * @Date: 2019/8/9 20:42
 * @Description: 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 *          设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 *          你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *          卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 *
 *          输入: [1,2,3,0,2]
 *          输出: 3
 *          解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 */
public class Solution {

    @Test
    public void function(){
        int[] arr = {1,2,3,0,2};
        System.out.println(maxProfit(arr));
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n <= 1)
            return 0;

        int[] hold = new int[n];        // 持有本金
        int[] profit = new int[n];      // 利润
        hold[0] = -prices[0];
        for (int i = 1; i < n; i++) {
            // 当天持有的最大金额 = Max（保持前一天的持有本金，即冷冻期 ： 两天前卖了，今天买入）
            hold[i] = Math.max(hold[i - 1], (i == 1 ? 0 : profit[i - 2]) - prices[i]);
            // 当天的最大利润 = Max（昨天卖出，然后今天啥都不干 ： 今天卖出）
            profit[i] = Math.max(profit[i - 1], prices[i] + hold[i - 1]);
        }

        return profit[n - 1];
    }

    // 另一个网上看到的更容易理解的解法
    public int otherSolution(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        // 由于可以无限次交易，所以只定义两个维度，第一个维度是天数，第二个维度表示是否持有股票，0表示不持有，1表示持有，2表示过渡期
        int[][] dp = new int[prices.length][3];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;

        // 这里只记录状态。即前一天卖出股票，这一天必定是过渡期，但肯定不会算作不持有股票状态；前一天买入股票，这一天可以卖出，也可以什么都不干，但肯定不会是过渡期
        for (int i = 1; i < prices.length; i++) {
            // 第i天不持有股票的情况有两种
            // a.第i-1天也不持有股票，第i天不操作
            // b.第i-1天是过渡期，第i天不操作
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);

            // 第i天持有股票有两种情况
            // a.第i-1天也持有股票，第i天不操作
            // b.第i-1天不持有股票，在第i天买入
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);

            // 第i天是冷冻期只有一种情况，第i-1天持有股票且卖出
            dp[i][2] = dp[i - 1][1] + prices[i];
        }

        // 最后最大利润为最后一天，不持有股票或者进入冷冻期的情况
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][2]);
    }
}
