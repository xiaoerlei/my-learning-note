package zhulei.JianzhiOffer.No42_和为S的两个数字;

import java.util.ArrayList;

/**
 * @Author: zl
 * @Date: 2019/6/10 20:32
 * @Description: 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 *          如果有多对数字的和等于S，输出两个数的乘积最小的。
 *
 *          对应每个测试案例，输出两个数，小的先输出。
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println(FindNumbersWithSum(arr, 8).toString());
    }

    /*
        思路：
            因为要求乘积最小，所以两个数的的差必定是越大越好
            定义两个指针，分别指向数组的头和尾，然后通过不断的比较和的值，来移动指针。
            如果找到了，就添加入集合，并跳出循环。否则输出为空
     */
    public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0, j = array.length - 1;
        while (i < j){
            int temp = array[i] + array[j];
            if(temp > sum)
                j--;
            else if(temp < sum)
                i++;
            else {
                list.add(array[i]);
                list.add(array[j]);
                break;
            }
        }
        return list;
    }
}
