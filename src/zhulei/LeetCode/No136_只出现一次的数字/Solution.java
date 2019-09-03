package zhulei.LeetCode.No136_只出现一次的数字;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @Author: zl
 * @Date: 2019/8/24 23:51
 * @Description: 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 *      说明：
 *          你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 *      输入: [4,1,2,1,2]
 *      输出: 4
 */
public class Solution {

    @Test
    public void function(){
        int[] nums = new int[]{4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }

    // 排序法
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            nums[0] = i % 2 == 1 ? nums[0] - nums[i] : nums[0] + nums[i];
        }
        return nums[0];
    }

    // 异或法
    public int singleNumbers(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[0] = nums[0] ^ nums[i];
        }
        return nums[0];
    }
}
