package zhulei.DataStructure.Sort.堆排序;

import java.util.Arrays;

/**
 * @Author: zl
 * @Date: 2021/8/2 00:45
 * @Description: 堆排测试
 */
public class HeapSortTest {

    public static void main(String[] args) {
        int[] arr = {5, 8, 6, 3, 7};

        System.out.println(Arrays.toString(MinHeap.minHeapSort(arr)));
        System.out.println(Arrays.toString(MinHeap.maxKHeapArray(arr, 2)));

        System.out.println(Arrays.toString(MaxHeap.maxHeapSort(arr)));
        System.out.println(Arrays.toString(MaxHeap.minKHeapArray(arr, 3)));
    }
}
