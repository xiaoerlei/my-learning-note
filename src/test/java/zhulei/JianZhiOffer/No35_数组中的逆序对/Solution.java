package zhulei.JianZhiOffer.No35_数组中的逆序对;

/**
 * @Author: zl
 * @Date: 2019/6/5 18:30
 * @Description: 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 *          输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。
 *          即输出P%1000000007
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,0};
        System.out.println(InversePairs(arr));
    }

    /*
        思路：
            主要考察的是排序问题，即每移动交换一次位置就存在一组逆序对。
            如果暴力求解，复杂度太高。所以这里比较好的方式是采取归并排序的方式来解决

            稍微改进一下归并排序算法，在交换位置的时候，如果出现逆序对，就对出现逆序对的数量进行统计
            最后不要忘记对1000000007取模
     */
    static long count = 0;
    public static int InversePairs(int [] array) {
        mergeSort(array, 0, array.length - 1);
        return (int) (count % 1000000007);
    }

    private static void mergeSort(int[] array, int start, int end) {
        if(start >= end)
            return;

        int mid = start + (end - start) / 2;

        mergeSort(array, start, mid);
        mergeSort(array, mid + 1, end);
        merge(array, start, mid, end);
    }

    // 将一个数组中的两个相邻有序区间合并成一个
    private static void merge(int[] array, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];

        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end){
            if(array[i] <= array[j])
                temp[k++] = array[i++];
            else {
                temp[k++] = array[j++];
                // 两个数组部分合并时，如果右边部分小于左边部分（存在逆序对），则统计当此比较时可能存在的逆序对的数量，并保存
                // 比如 1 5 6 | 2 7 8。2小于5和6，多以应该这次比较应该有3-2+1=2对逆序对
                count += mid - i + 1;
            }
        }

        while (i <= mid)
            temp[k++] = array[i++];
        while (j <= end)
            temp[k++] = array[j++];

        for (int l = 0; l < temp.length; l++) {
            array[start + l] = temp[l];
        }
    }
}
