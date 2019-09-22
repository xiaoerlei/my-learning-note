package zhulei.JianzhiOffer.No29_最小的K个数;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: zl
 * @Date: 2019/5/31 14:37
 * @Description: 输入n个整数，找出其中最小的K个数。
 *              例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = {4,5,1,6,2,7,3,8};
        System.out.println(GetLeastNumbers_Solution(arr, 4));
    }

    // 偷个懒，暂时调库来做的。当然这个题用patition的方式解决可以达到O（n）的复杂度。以后回头有空再解决着看看
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(input.length < k)
            return list;
        Arrays.sort(input);
        for (int i = 0; i < k; i++)
            list.add(input[i]);
        return list;
    }

    // 基于快排
    public ArrayList<Integer> GetLeastNumbers_BaseQuickSort(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(k > input.length || k == 0)
            return list;

        quickSort(input, 0, input.length - 1);

        for(int i = 0; i < k; i++)
            list.add(input[i]);

        return list;
    }

    public void quickSort(int[] arr, int low, int high){
        int i, j, temp;
        if(low > high)    return;

        i = low; j = high;
        temp = arr[low];
        while(i < j){
            while(arr[j] >= temp && i < j)
                j--;

            while(arr[i] <= temp && i < j)
                i++;

            if(i < j)
                swap(arr, i, j);
        }
        arr[low] = arr[i];
        arr[i] = temp;

        quickSort(arr, low, i - 1);
        quickSort(arr, i + 1, high);
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
