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
     * 返回数组最小的k个数字  ->  时间优先，所以小顶堆以最快的速度计算的最小topK
     * （这种是优化排序算法，因为小顶堆的最顶层是数组中最小的元素，所以每次都会把最大的元素放到最末尾，因此minK，就是只循环k次来调整堆）
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
     * 返回数组中最大的k个数字  ->  空间优先，所以小顶堆以最小的空间计算的最大topK
     * （在限定 2k 的空间大小，数组可能大于等于2k的长度，来求取前k个最大数值）
     * @param arr
     * @param k
     * @return
     */
    public static int[] maxKHeapArray(int[] arr, int k) {
        int[] fixArr = arr.length >= k * 2 ? Arrays.copyOf(arr, k * 2) : arr;
        int index = k;
        // 每次都移动下标，直到所有的元素都在堆中调整过
        while (index < arr.length) {
            // 每次重新复制后面5个元素，用来重新给堆排序
            for (int i = k; i < 2 * k && index < arr.length ; i++, index++) {
                fixArr[i] = arr[index];
            }
            // 建堆（让值最小的节点向上移动）
            for (int i = fixArr.length / 2 - 1; i >= 0; i--) {
                adjustHeap(fixArr, i, fixArr.length);
            }
            // 调整
            for (int i = fixArr.length - 1; i > 0; i--) {
                // 交换 根节点 和 当前节点
                CommonUtils.swap(fixArr, 0, i);
                // 自上而下，自左向右进行调整，每次让子结点中较小值的节点，与父节点进行交换
                adjustHeap(fixArr, 0, i);
            }
        }

        return Arrays.copyOf(fixArr, k);
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
