package zhulei.LeetCode.No213_打家劫舍II;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @Author: zl
 * @Date: 2019/8/13 15:24
 * @Description: 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。
 *          同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 *          给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 *              输入: [2,3,2]
 *              输出: 3
 *              解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 *
 *              输入: [1,2,3,1]
 *              输出: 4
 *              解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *                      偷窃到的最高金额 = 1 + 3 = 4 。
 *
 *
 */
public class Solution {

    @Test
    public void function(){
        int[] arr = {1,2,1,1};
        System.out.println(rob(arr));
    }


    public int rob(int[] nums) {
        int n = nums.length;
        // 因为最终的结果需要判断dp[n - 2]，所以为了防止数组越界，需要对小于等于2范围的数组先行判定
        if(n <= 0)  return 0;
        if(n == 1)  return nums[0];
        if(n == 2)  return Math.max(nums[0], nums[1]);

        // 定义两个数组，一个去掉第一个元素，另外一个去掉最后一个元素
        // dp为（0， n-2）范围的最高金额
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n - 1; i++) {
            for (int j = i; j >= 0; j--) {
                dp[i] = Math.max(dp[i], nums[j] + (j - 2 >= 0 ? dp[j - 2] : 0));
            }
        }

        // dpCmp为（1， n-1）范围的最高金额
        int[] dpCmp = new int[n];
        dpCmp[1] = nums[1];
        for (int i = 2; i < n; i++) {
            for (int j = i; j >= 1; j--) {
                dpCmp[i] = Math.max(dpCmp[i], nums[j] + (j - 2 >= 0 ? dpCmp[j - 2] : 0));
            }
        }

        // 最终的最大金额为dp和dpCmp之间的最大值。避开了环路，这样就有效的解决了环路问题
        return Math.max(dp[n - 2], dpCmp[n - 1]);
    }
}
