package zhulei.DataStructure.Sort.归并排序;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @Author: zl
 * @Date: 2019/6/7 14:03
 * @Description: 自底向上归并排序
 */
public class DownToUpMergeSort {

    @Test
    public void fun(){
        int[] arr = {49, 38, 65, 97, 76, 13, 27, 50};
        MergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void MergeSort(int[] arr) {
        if(arr.length == 0)
            return;
        // len表示归并子数组的长度，1表示，一个一个的归并，归并后的长度为2,2表示两个两个的归并，归并后的长度为4,以此类推
        for (int len = 1; len < arr.length; len *= 2)
            // 按照len的长度归并回arr数组，归并后长度翻倍
            for (int start = 0; start < arr.length; start += len * 2)
                // 对于数组长度不满足2的x次幂的数组，mid可能会大于end
                merge(arr, start, start + len - 1, Math.min(start + len * 2 - 1, arr.length - 1));
                
    }

    // 这里复用自顶向下的归并的合并方法
    private void merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[arr.length];
        // 定义三个指针。分别指向合并前的两个数组，以及temp数组
        int i = start, j = mid + 1, k = start;
        // 比较然后赋值，保证temp有序（不断的保证每个部分是有序的，最后逐一比较，合并成完整数组才会有序）
        while (i <= mid && j <= end){
            if(arr[i] < arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }

        // 之前的while循环因为 i>mid 或 j>end 而跳出循环，所以之后需要把剩下一边没有遍历完的部分遍历完毕
        while (i <= mid)
            temp[k++] = arr[i++];
        while (j <= end)
            temp[k++] = arr[j++];
        // 最后对原数组进行重新赋值
        for (int l = start; l <= end; l++)
            arr[l] = temp[l];

    }
}
