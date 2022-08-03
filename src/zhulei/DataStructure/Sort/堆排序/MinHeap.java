package zhulei.DataStructure.Sort.堆排序;

import zhulei.Utils.CommonUtils;
import java.util.Arrays;

/**
 * @Author: zl
 * @Date: 2022/8/2 00:13
 * @Description: 最小顶堆
 */
public class MinHeap {

    /**
     * 返回数组最大的k个数字（无序）
     * @param arr
     * @param k
     * @return
     */
    public static int[] minKHeapArray(int[] arr, int k) {
        // 建堆（让值最小的节点向上移动）
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        // 排序（从最后一个节点开始，依次向前，每次都跟头节点交换，然后重新调整堆）
        int bound = k;
        for (int i = arr.length - 1; i > 0; i--, k--) {
            if(k == 0) {
                return Arrays.copyOfRange(arr, arr.length - bound, arr.length);
            }
            // 交换 根节点 和 当前节点
            CommonUtils.swap(arr, 0, i);
            // 自上而下，自左向右进行调整，每次让子结点中较小值的节点，与父节点进行交换
            adjustHeap(arr, 0, i);
        }
        return arr;
    }

    /**
     * 小顶堆排序
     * @param arr
     * @return
     */
    public static int[] minHeapSort(int[] arr) {
        return minKHeapArray(arr, arr.length);
    }

    // 调整小顶堆
    private static void adjustHeap(int[] arr, int i, int length) {
        // 定义左右叶子节点的角标
        int left = 2 * i + 1, right = 2 * i + 2;
        // 定义最大值节点的角标，并比较指向最大节点
        int minIndex = i;
        if (left < length && arr[left] < arr[minIndex]) {
            minIndex = left;
        }
        if (right < length && arr[right] < arr[minIndex]) {
            minIndex = right;
        }
        // 如果最大值在子节点上，则交换位置
        if (minIndex != i) {
            CommonUtils.swap(arr, minIndex, i);
            // 交换后节点发生了变化，所以要再次调整，直到满足小顶堆的条件
            adjustHeap(arr, minIndex, length);
        }
    }

}
