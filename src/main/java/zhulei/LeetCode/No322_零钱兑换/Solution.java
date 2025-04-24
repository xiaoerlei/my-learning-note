package zhulei.LeetCode.No322_零钱兑换;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @Author: zl
 * @Date: 2019/8/21 22:26
 * @Description: 给定不同面额的硬币 coins 和一个总金额 amount。
 *          编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 *          输入: coins = [1, 2, 5], amount = 11
 *          输出: 3
 *          解释: 11 = 5 + 5 + 1
 *
 */
public class Solution {

    @Test
    public void function(){
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }

    public int coinChange(int[] coins, int amount) {
        // 如果金额为0，则说明不需要金币
        if(amount == 0)
            return 0;

        // 创建一个amount + 1容量的数组，并赋初值为amount，利用减法来找到合适的解集
        int[] dp = new int[amount + 1];
        // 这里给dp数组设置初始值的时候，一定要设置比amount大的一个数，可以为amount + n。这样才能保证最后返回值的判断
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if(i >= coin)
                    // 状态转移方程后面+1，目的是获取最小单位的金币数量
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        // 如果dp[amount]发生了更改，则必定是小于amount的。如果大于amount，则说明不存在满足条件的情况
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
