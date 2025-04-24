package zhulei.LeetCode.No88_合并两个有序数组;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

/**
 * @Author: zl
 * @Date: 2019/8/20 20:32
 * @Description: 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 *          说明:
 *              初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 *              你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 *          输入:
 *              nums1 = [1,2,3,0,0,0], m = 3
 *              nums2 = [2,5,6],       n = 3
 *
 *          输出: [1,2,2,3,5,6]
 *
 */
public class Solution {

    @Test
    public void function(){
        int[] nums1 = {1,2,3,5,6,0};
        int[] nums2 = {4};
        merge(nums1, 5, nums2, 1);
        System.out.println(Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /*
            把nums1包含值得部分移到数组的末尾。比如：{1,2,3,5,6,0} -> {1,1,2,3,5,6}  往前移动一位

            下面代码中，index表示没有移动位置之前，6的位置，即包含值的最末尾的位置。从后往前不断的挪动值的位置
         */
        for (int i = nums1.length - 1, index = m - 1; index >= 0; i--) {
            nums1[i] = nums1[index--];
        }

        // count指向数组开始的角标指针
        int count = 0;
        // i指向num1，j指向num2
        int i = nums1.length - m, j = 0;
        // 在满足i和j都没有指向数组末尾的情况下，不断的比较，把值较小的那个值存在num1的count指针指向的位置，并移动两个指针
        while (i < nums1.length && j < n){
            if(nums1[i] < nums2[j]) {
                nums1[count++] = nums1[i++];
            }
            else
                nums1[count++] = nums2[j++];
        }

        // 如果num2没有遍历完，遍历剩下的num2数组没有遍历完的部分（num1那部分不用继续遍历完，因为num1后半段本身就是有序的）
        while (j < n)
            nums1[count++] = nums2[j++];
    }
}
