package zhulei.LeetCode.No80_删除排序数组中的重复项II;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @Author: zl
 * @Date: 2019/8/21 20:35
 * @Description: 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 *          不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 *          给定 nums = [1,1,1,2,2,3],
 *
 *          函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 *          你不需要考虑数组中超出新长度后面的元素。
 *
 */
public class Solution {

    @Test
    public void function(){
        int[] arr = {0,0,1,1,1,1,2,3,3};
        System.out.println(removeDuplicates(arr));
    }

    /*
        思路：
            定义一个修改指针指向需要修改的数组的位置，另外一个指针来遍历数组，并用一个计数器index来统计数组里面相同数字出现的频率

            每当index小于2的时候，就移动一次修改指针，然后把遍历指针指向的值赋给修改指针指向的值。这样就保证了在原有的基础上进行了修改
            注意，最后遍历完时，需要在数组最末尾处再进行一次判断，看是否需要移动指针
     */
    public int removeDuplicates(int[] nums) {
        int count = 0, index = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if(index < 2)
                nums[count++] = nums[i];

            if(nums[i] == nums[i + 1])
                index++;
            else
                index = 0;
        }

        if(nums.length == 1 || nums.length == 2 || nums.length > 2 && index < 2)
            nums[count++] = nums[nums.length - 1];

        System.out.println(Arrays.toString(nums));
        return count;
    }
}
