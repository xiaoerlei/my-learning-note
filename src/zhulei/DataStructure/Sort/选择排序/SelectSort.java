package zhulei.DataStructure.Sort.选择排序;

/**
 * @Author: zl
 * @Date: 2019/4/7 22:44
 * @Description: 每一趟从待排序的数据元素中选择最小（或最大）的一个元素作为首元素，
 *              之后再从后续乱序的n - 1个元素中，在选取最小的元素，放在刚刚选择的元素的后面
 *              不断重复上面的操作，直到所有元素排完为止
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {5, 8, 6, 3, 7};
        selectSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[i] > arr[j])
                    swap(arr, i, j);
            }
        }
    }

    // 交换位置
    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
