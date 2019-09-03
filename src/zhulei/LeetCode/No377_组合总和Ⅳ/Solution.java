package zhulei.LeetCode.No377_组合总和Ⅳ;

import org.junit.jupiter.api.Test;

/**
 * @Author: zl
 * @Date: 2019/8/22 13:19
 * @Description: 给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
 *
 *          nums = [1, 2, 3]
 *          target = 4
 *
 *          所有可能的组合为：
 *              (1, 1, 1, 1)
 *              (1, 1, 2)
 *              (1, 2, 1)
 *              (1, 3)
 *              (2, 1, 1)
 *              (2, 2)
 *              (3, 1)
 *
 *          请注意，顺序不同的序列被视作不同的组合。
 */
public class Solution {

    @Test
    public void function(){
        int[] nums = {1, 2, 3};
        int target = 4;
        System.out.println(combinationSum4(nums, target));
    }

    /*
        思路：
            对于返回最多组合个数的题目不能采取dfs的做法，因为一定会超时。所以这里采用动态规划的做法

            而根据题目意思是可以知道：
                dp[target] = dp[target - nums[0]] + dp[nums[1]] + dp[nums[2]]。所以其实也可以看成是一个爬楼梯的问题
     */
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        // 初始值为1，表示默认包含自身的一种情况。即 0 只能由 0 组成，类似的 dp[1] = dp[1] + dp[0] 即只能由 0 和 1 一种组合方式
        dp[0] = 1;  // 包含本身，所以初始为一种情况
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if(i >= num)
                    dp[i] += dp[i - num];
            }
        }

        return dp[target];
    }
}
