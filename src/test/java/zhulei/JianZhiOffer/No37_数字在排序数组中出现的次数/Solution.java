package zhulei.JianZhiOffer.No37_数字在排序数组中出现的次数;

import java.util.Arrays;

/**
 * @Author: zl
 * @Date: 2019/6/6 15:29
 * @Description: 统计一个数字在排序数组中出现的次数。
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = {1,3,3,3,3,4,5};
        System.out.println(GetNumberOfK(arr, 2));
    }

    // 基于二分查找法。找到对应k的角标，然后分别向角标的左右查询是否存在与k相等的值
    public static int GetNumberOfK(int [] array , int k) {
        int count = 0;
        int right = Arrays.binarySearch(array, k);
        // 没有查找到，直接返回
        if(right < 0)
            return 0;
        // 零时保存查询到的index，便于从另一个方向查询与k相同的值
        int left = right;
        // 从右边开始查找
        while (right < array.length && array[right++] == k)
            count++;
        // 从左边开始查找
        while (left > 0 && array[--left] == k)
            count++;

        return count;
    }
}
