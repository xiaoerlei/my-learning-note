package zhulei.DataStructure.Sort.插入排序;

/**
 * @Author: zl
 * @Date: 2019/4/7 18:52
 * @Description: 把n个待排序的元素看成为一个有序表和一个无序表。
 *              开始时有序表中只包含1个元素，无序表中包含有n-1个元素，排序过程中从无序表中取出第一个元素，
 *              将它插入到有序表中的适当位置，使之成为新的有序表，
 *              每次循环，多拿出无序表中的一个元素，然后与之前排好序的进行比较插入，
 *              重复n-1次可完成排序过程。
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {5, 8, 6, 3, 7};
        insertSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void insertSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {

            // 寻找元素arr[i]合适的插入位置
            // 写法1
//            for( int j = i ; j > 0 ; j -- )
//                if( arr[j] < arr[j - 1] )
//                    swap(arr, j, j - 1);
//                else
//                    break;

            // 写法2
            for( int j = i; j > 0 && arr[j] < arr[j - 1] ; j--)
                swap(arr, j, j - 1);

            // 写法3
//            int e = arr[i];
//            int j = i;
//            for( ; j > 0 && arr[j - 1] > e; j--)
//                arr[j] = arr[j - 1];
//            arr[j] = e;

        }
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
