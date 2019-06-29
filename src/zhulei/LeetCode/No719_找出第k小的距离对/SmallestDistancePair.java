package zhulei.LeetCode.No719_找出第k小的距离对;


import java.util.Arrays;

/**
 * @Author: zl
 * @Date: 2019/6/28 10:15
 * @Description: 给定一个整数数组，返回所有数对之间的第 k 个最小距离。一对 (A, B) 的距离被定义为 A 和 B 之间的绝对差值。
 *
 *          例如：
 *              输入：nums = [1,3,1], k = 1
 *              输出：0
 *
 *          解释：
 *              所有数对如下：
 *                  (1,3) -> 2
 *                  (1,1) -> 0
 *                  (3,1) -> 2
 *              因此第 1 个最小距离的数对是 (1,1)，它们之间的距离为 0。
 */
public class SmallestDistancePair {

    public static void main(String[] args) {
        int[] nums = {1,3,1,5,3,6,7,9,3,2};
        System.out.println(smallestDistancePair(nums, 4));
    }

    /*
        思路：
            首先找到最大的差值，即排完序后数组的第一位和最后一位的差值

            然后利用二分查找的思路，提高查找效率，找出最大差值的中间值。
                计算差值小于中间值的个数count（因为目的是要找到第k小的差值）
                    - 如果count < k，则说明要找的第k个值在后半段
                    - 如果count > k，则说明在前半段
     */
    public static int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = nums[nums.length - 1] - nums[0];

        while(left < right){
            int mid = left + (right - left) / 2;
            int count = getCount(nums, mid);
            // 注意这里的二分查找左边界和右边界更新的标准
            if(count < k)
                left = mid + 1;     // 小于k，mid必然非最终解，因此left = mid + 1
            else
                right = mid;     // 大于等于k，可以将mid作为候选解
        }

        return left;
    }

    // 差值 小于等于 mid 的个数
    public static int getCount(int[] nums, int mid){
        int count = 0;
        int left = 0;
        // 使用窗口思想，判断 差值<=k 的个数，r-l 即表示[l,r]间 间隔<m 的个数（每确定一个窗口就新增加了（r-l+1）- 1个差值对）
        for(int right = 1; right < nums.length; right++){
            while(nums[right] - nums[left] > mid)
                left++;     // 移动左边界

            count += right - left;
        }

        return count;
    }
}
