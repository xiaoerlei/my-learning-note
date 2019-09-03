package zhulei.LeetCode.No169_求众数;

import org.junit.jupiter.api.Test;

/**
 * @Author: zl
 * @Date: 2019/8/25 0:13
 * @Description: 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 *          你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 *          输入: [2,2,1,1,1,2,2]
 *          输出: 2
 */
public class Solution {

    @Test
    public void function(){
        int[] arr = {2,2,1,1,1};
        System.out.println(majorityElement(arr));
    }

    // 选举做法（O n 时间 | O 1 空间）
    /*
        已知数组一定不为空，所以一定存在众数，且众数大于数组长度的一班

        所以，假设众数为数组的第一个元素，并记录众数的个数，初始化为1；
             每次出现与当前众数相同的数，众数的个数+1，反之-1；
             如果众数的个数为0了，说明当前选取的这个众数很可能不是众数，所以选择最新的一个数为新的众数；
             基于这个想法，可以推断，当count不为0时，选取的众数，就一定是出现次数最多的那个数字
     */
    public int majorityElement(int[] nums) {
        int count = 1;
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(count == 0)
                res = nums[i];

            if(nums[i] == res)
                count++;
            else
                count--;
        }
        return res;
    }
}
