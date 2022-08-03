package zhulei.DataStructure.Sort.堆排序;

import zhulei.Utils.CommonUtils;
import java.util.Arrays;

/**
 * @Author: zl
 * @Date: 2019/4/21 11:00
 * @Description: 最大顶堆
 */
public class MaxHeap {

    /**
     * 按照完全二叉树的特点，从最后一个非叶子节点开始，对于整棵树进行大根堆的调整
     * 也就是说，是按照自下而上，每一层都是自右向左来进行调整的
     *
     * @param arr
     * @param k
     */
    public static int[] maxKHeapArray(int[] arr, int k) {
        // 建堆（让值最大的节点向上移动）
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        int bound = k;
        // 排序（从最后一个节点开始，依次向前，每次都跟头节点交换，然后重新调整堆）
        for (int i = arr.length - 1; i > 0; i--) {
            if(k-- == 0) {
                return Arrays.copyOfRange(arr, arr.length - bound, arr.length);
            }
            // 元素交换，其实质就是把大顶堆的根元素，放到数组的最后；换句话说，就是每一次的堆调整之后，都会有一个元素到达自己的最终位置
            CommonUtils.swap(arr, 0, i);
            // 元素交换之后，毫无疑问，最后一个元素无需再考虑排序问题了。
            // 接下来我们需要排序的，就是已经去掉了部分元素的堆了，这也是为什么此方法放在循环里的原因
            // 而这里，实质上是自上而下，自左向右进行调整的，每次让子结点中较大值的节点，与父节点进行交换
            adjustHeap(arr, 0, i);
        }
        return arr;
    }

    /**
     * 大顶堆排序
     * @param arr
     * @return
     */
    public static int[] maxHeapSort(int[] arr) {
        return maxKHeapArray(arr, arr.length);
    }

    /**
     * 调整大顶堆
     * @param arr 待调整数组
     * @param i 非叶子节点在数组中的索引
     * @param length 调整元素个数
     */
    private static void adjustHeap(int[] arr, int i, int length) {
        // 保存父节点的值，用于比较交换
        int temp = arr[i];
        // 自上而下，自左向右一点点调整整棵树的部分，直到每一颗小子树都满足大根堆为止
        for (int k = 2 * i + 1; k < length; k = k * 2 + 1) {
            // 如果 左子节点 小于 右子节点，则k指向右子节点（k指向值大的子节点）
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            // 子节点大于父节点，则交换
            if (arr[k] > temp) {
                CommonUtils.swap(arr, i, k);
                // 如果子节点更换了，那么，以子节点为根的子树也会受到影响。 所以，循环对子节点所在的树继续进行判断
                i = k;
            } else {
                // 如果不用交换，那么，就直接终止循环了
                break;
            }
        }
    }

}
