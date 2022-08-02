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
    public static int[] maxKHeapArray(int[] arr, int k) {
        // 建堆（让值最小的节点向上移动）
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        // 排序（从最后一个节点开始，依次向前，每次都跟头节点交换，然后重新调整堆）
        int bound = k;
        for (int i = arr.length - 1; i > 0; i--, k--) {
            if(k == 0) {
                return Arrays.copyOf(arr, bound);
            }
            // 交换 根节点 和 当前节点
            CommonUtils.swap(arr, 0, i);
            // 自上而下，自左向右进行调整
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
        return maxKHeapArray(arr, arr.length);
    }


    // 每次让子结点中较小值的节点，与父节点进行交换
    private static void adjustHeap(int[] arr, int i, int length) {
        // 临时保存一个temp，便于后面交换之后的比较
        int temp = arr[i];
        // 自上而下，自左向右一点点调整整棵树的部分，直到每一颗小子树都满足小根堆为止
        for (int k = 2 * i + 1; k < length; k = k * 2 + 1) {
            // 让k先指向子节点中最小的节点
            if (k + 1 < length && arr[k] > arr[k + 1])
                k++;
            // 如果发现子节点更小，则进行值的交换
            if (arr[k] < temp) {
                CommonUtils.swap(arr, i, k);
                // 如果子节点更换了，那么，以子节点为根的子树也会受到影响。 所以，循环对子节点所在的树继续进行判断
                i = k;
                // 如果不用交换，那么，就直接终止循环了
            } else
                break;
        }
    }

}
