package zhulei.JianZhiOffer.No13_调整数组顺序使奇数位于偶数前面;

import java.util.Arrays;

/**
 * @Author: zl
 * @Date: 2019/5/26 16:32
 * @Description: 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 *          使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        reOrderArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void reOrderArray(int [] array) {
        int oddCount = 0;
        // 计算数组中奇数的数量
        for (int i = 0; i < array.length; i++)
            if(array[i] % 2 == 1)
                oddCount++;

        // 新建一个相同的数组，作为参考数组
//        int[] newArray = Arrays.copyOf(array, array.length);
        int[] newArray = array.clone();
        int oddIndex = 0, evenIndex = oddCount;
        // 分别对奇数边和偶数边进行赋值
        for (int i = 0; i < newArray.length; i++) {
            if(newArray[i] % 2 == 1)
                array[oddIndex++] = newArray[i];
            else
                array[evenIndex++] = newArray[i];
        }
    }
}
