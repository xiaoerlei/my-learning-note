package zhulei.LeetCode.No215_数组中的第K个最大元素;

import org.junit.jupiter.api.Test;

/**
 * @Author: zl
 * @Date: 2019/8/19 14:21
 * @Description: 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 *      输入: [3,2,1,5,6,4] 和 k = 2
 *      输出: 5
 *
 *      输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 *      输出: 4
 */
public class Solution {

    @Test
    public void function(){
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(findKthLargest(nums, k));
    }

    /*
        桶排序思想：
            先计算出数组的最大值和最小值，计算得到桶的容量为Max - Min；
            再定义一个Max - Min容量的桶，然后把元素依次放入桶中；
            顺着桶找到第K大的元素

         缺点：会消耗过多的容量
     */
    public int findKthLargest(int[] nums, int k) {
        int Min = Integer.MAX_VALUE, Max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < Min)   Min = nums[i];
            if(nums[i] > Max)   Max = nums[i];
        }

        int capacity = Max - Min;
        int[] bucket = new int[capacity + 1];
        for (int i = 0; i < nums.length; i++) {
            bucket[nums[i] - Min]++;
        }

        // 对每个桶进行遍历，找到第七个元素的桶
        for (int i = bucket.length - 1; i >= 0; i--) {
            if(bucket[i] > 0)
                k -= bucket[i];

            // 找到了则返回 最小值与当前索引的和
            if(k <= 0)
                return Min + i;
        }

        return -1;
    }
}
