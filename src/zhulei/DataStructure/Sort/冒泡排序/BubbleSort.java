package zhulei.DataStructure.Sort.冒泡排序;

/**
 * @Author: zl
 * @Date: 2019/4/6 15:11
 * @Description: 原理：比较两个相邻的元素，将值大的元素交换至右端。
 *
 *      思路：依次比较相邻的两个数，将小数放在前面，大数放在后面。
 *            即在第一趟：首先比较第1个和第2个数，将小数放前，大数放后。
 *            然后比较第2个数和第3个数，将小数放前，大数放后，
 *            如此继续，直至比较最后两个数，将小数放前，大数放后。重复第一趟步骤，直至全部排序完成。
 *
 *          第一趟比较完成后，最后一个数一定是数组中最大的一个数，所以第二趟比较的时候最后一个数不参与比较；
 *          第二趟比较完成后，倒数第二个数也一定是数组中第二大的数，所以第三趟比较的时候最后两个数不参与比较；
 *          ......
 *          依次类推，每一趟比较次数-1；
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {5, 8, 6, 3, 7};
        bubbleSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void bubbleSort(int[] arr) {
        // 外层表示需要循环次数
        for (int i = 0; i < arr.length; i++) {
            // 内层表示每次循环的比较对象（每相邻的两个元素需要比较一次，且每次循环都往前推移，少比较一次）
            for (int j = 0; j < arr.length - i - 1; j++) {
                // 注：如果传入两个参数，则交换顺序不能用方法来实现。因为方法只返回对值的改变，不反悔对引用的改变
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                // 如果传入三个参数，就可以实现交换
//                swap(arr, j, j + 1);
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
