package zhulei.DataStructure.Sort.堆排序;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @Author: zl
 * @Date: 2021/8/2 00:45
 * @Description: 堆排测试
 */
public class HeapSortTest {

    @Test
    void fun() {
        int[] arr = {5, 8, 6, 3, 7, 4, 9};

        // 测试小顶堆 排序
        System.out.println(Arrays.toString(MinHeap.minHeapSort(arr)));
        // 小顶堆 topK
        System.out.println(Arrays.toString(MinHeap.minKHeapArray(arr, 2)));
        // 小顶堆 tokMaxK
        System.out.println(Arrays.toString(MinHeap.maxKHeapArray(arr, 3)));

        // 测试大顶堆 排序
        System.out.println(Arrays.toString(MaxHeap.maxHeapSort(arr)));
        // 大顶堆 topK
        System.out.println(Arrays.toString(MaxHeap.maxKHeapArray(arr, 3)));
    }
}
