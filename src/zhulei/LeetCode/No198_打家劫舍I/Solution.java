package zhulei.LeetCode.No198_打家劫舍I;

import org.junit.jupiter.api.Test;

/**
 * @Author: zl
 * @Date: 2019/8/9 19:39
 * @Description: 你是一个专业的小偷，计划偷窃沿街的房屋。
 *          每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *          给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 *          输入: [1,2,3,1]
 *          输出: 4
 *
 *          输入: [2,7,9,3,1]
 *          输出: 12
 */
public class Solution {

    @Test
    public void function(){
        int[] num = {1,2,3,1};
        System.out.println(rob(num));
        System.out.println(robb(num));
    }

    // 从后往前
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0)
            return 0;

        int[] dp = new int[n];
        dp[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                // 当j + 2 > n，超出范围，默认为0
                dp[i] = Math.max(dp[i], nums[j] + (j + 2 < n ? dp[j + 2] : 0));
            }
        }

        return dp[0];
    }

    // 从前往后
    public int robb(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;

        int[] dp = new int[n];
        dp[0] = nums[0];

        for (int i = 1; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                // 注意这里选择的是nums[j]，而非nums[i]。是用当前的价值，来和之前的最大记录做状态转移
                dp[i] = Math.max(dp[i], nums[j] + (j - 2 >= 0 ? dp[j - 2] : 0));
            }
        }
        return dp[n - 1];
    }
}
