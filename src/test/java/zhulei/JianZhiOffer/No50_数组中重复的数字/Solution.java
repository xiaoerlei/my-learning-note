package zhulei.JianZhiOffer.No50_数组中重复的数字;

/**
 * @Author: zl
 * @Date: 2019/6/15 14:21
 * @Description: 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 *          数组中某些数字是重复的，但不知道有几个数字是重复的。
 *          也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 *          例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = {2,3,1,0,2,5,3};
        System.out.println(duplicate(arr, arr.length, new int[]{0}));
    }

    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public static boolean duplicate(int numbers[],int length,int [] duplication) {
        if(length == 0)
            return false;
        /*
            尤其要注意的两个条件：
                 1、numbers[i] != i。 在当前位置的值和当前位置相等时，直接跳过此次循环
                 2、numbers[i] == numbers[numbers[i]]。  如果存在当前位置的值，和要交换的值相等的情况下。则直接返回（否则就进入了死循环）
         */
        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {
                if(numbers[i] == numbers[numbers[i]]){
                    duplication[0] = numbers[i];
                    return true;
                }
                swap(numbers, numbers[i], i);
            }
        }

        return false;
    }

    private static void swap(int[] numbers, int x, int y) {
        int temp = numbers[x];
        numbers[x] = numbers[y];
        numbers[y] = temp;
    }
}
