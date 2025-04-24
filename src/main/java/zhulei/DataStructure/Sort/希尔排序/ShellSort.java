package zhulei.DataStructure.Sort.希尔排序;

/**
 * @Author: zl
 * @Date: 2019/4/6 15:28
 * @Description: 希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；
 *              随着增量逐渐减少，每组包含的关键词越来越多，当增量减至1时，整个文件恰被分成一组，算法便终止。
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {5, 8, 6, 3, 7};
        shellSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    // 希尔排序
    private static void shellSort(int[] arr) {
        int N = arr.length;
        // 进行分组，最开始的增量gap未数组长度的一半
        for (int gap = N / 2; gap > 0; gap /= 2)
            // 对各个分组进行插入排序
            for (int i = gap; i < N; i++) {
                insertSort(arr, gap, i);
            }
    }

    // 插入排序
    private static void insertSort(int[] arr, int gap, int i) {
        // 插入的时候按组进行插入（组内元素两两相隔gap）
        for (int j = i - gap; j > 0 && arr[j] < arr[j - 1] ; j -= gap) {
            swap(arr, j, j - 1);
        }
    }

    // 交换位置
    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
