package zhulei.JianzhiOffer.No32_把数组排成最小的数;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Author: zl
 * @Date: 2019/5/31 16:53
 * @Description: 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *              例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = {3,32,321};
        System.out.println(PrintMinNumber(arr));
    }

    public static String PrintMinNumber(int [] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++)
            list.add(numbers[i]);

        // 对于指定顺序的序列，都只需要在Comparator中来自定义比较的规则即可
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // 每次把两个字符串按不同的两种方式拼接。就能得到指定的排序规则
                String s1 = o1 + "" + o2;
                String s2 = o2 + "" + o1;
                return s1.compareTo(s2);
            }
        });

        String res = "";
        for (int i = 0; i < list.size(); i++)
            res += list.get(i);

        return res;
    }
}
