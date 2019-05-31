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
}
