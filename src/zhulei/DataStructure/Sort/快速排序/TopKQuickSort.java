package zhulei.DataStructure.Sort.快速排序;

import zhulei.Utils.CommonUtils;

import java.util.Arrays;

public class TopKQuickSort {

    public static void main(String[] args) {
        int[] arr = {9, 5, 6, 7, 1, 3, 8, 2};
        int k = 5;
        // k 是数组角标，所以要减一
        int[] res = topKQuickSort(arr, 0, arr.length - 1, k - 1);
        System.out.println(Arrays.toString(res));
    }

    private static int[] topKQuickSort(int[] arr, int left, int right, int k) {
        // 快排切分，返回下标j，使得比arr[j]小的数都在j的左边，比arr[j]大的数都在j的右边
        int index = quickSortPart(arr, left, right);
        // 如果排好序之后，数组的角标正好等于k，则前k个数恰好就是最小的k个数
        if(index == k) {
            return Arrays.copyOf(arr, index + 1);
        }
        // 否则根据下标j与k的大小关系来决定继续切分左段还是右段
        return index > k ? topKQuickSort(arr, left, index - 1, k) : topKQuickSort(arr, index + 1, right, k);
    }

    private static int quickSortPart(int[] arr, int left, int right) {
        int temp = arr[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (arr[j] >= temp && i < j) {
                j--;
            }
            while (arr[i] <= temp && i < j) {
                i++;
            }
            CommonUtils.swap(arr, i, j);
        }
        arr[left] = arr[i];
        arr[i] = temp;
        return j;
    }

}
