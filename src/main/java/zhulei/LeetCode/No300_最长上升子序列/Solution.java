package zhulei.LeetCode.No300_最长上升子序列;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @Author: zl
 * @Date: 2019/8/18 19:00
 * @Description: 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 *      输入: [10,9,2,5,3,7,101,18]
 *      输出: 4
 *      解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 */
public class Solution {

    @Test
    public void function(){
        int[] nums = {1,3,6,7,9,4,10,5,6};
        System.out.println(lengthOfLIS(nums));
        System.out.println(lengthOfLISS(nums));
    }

    // 动态规划
    /*
        每次符合后面的元素大于前面的元素时，都在dp数组中进行记录，记录的情况即为当前元素之前小于当前元素的个数。

        最后要找到最大的长度则需要排序后来确定
     */
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++)
            for (int j = 0; j < i; j++)
                if(nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
        Arrays.sort(dp);

        return dp[n - 1];
    }

    // 贪心算法+二分查找
    /*
        创建一个tail数组来保存最长上升序列
            每当出现最新的元素大于当前tail数组的最后一个元素，则添加至tail的尾部，数组的长度+1；
            反之则找到tail数组中恰好大于或等于当前最新元素的位置，然后进行替换

            这样就能恰好保证tail数组中是一个最优且最长的上升子序列
     */
    public int lengthOfLISS(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        // tail数组来保存最长上升序列
        int[] tail = new int[n];
        tail[0] = nums[0];
        int end = 0;
        for (int i = 1; i < n; i++) {
            // 如果符合条件，则添加至尾部
            if (nums[i] > tail[end]){
                end++;
                tail[end] = nums[i];
            }
            // 否则进行二分查找，然后替换
            else {
                int left = 0, right = end;
                while (left < right){
                    int mid = left + (right - left) / 2;
                    if(nums[i] > tail[mid])
                        left = mid + 1;
                    else
                        right = mid;
                }

                tail[left] = nums[i];
            }
        }
        end++;
        return end;
    }
}
