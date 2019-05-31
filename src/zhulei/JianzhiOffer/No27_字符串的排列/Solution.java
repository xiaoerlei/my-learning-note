package zhulei.JianzhiOffer.No27_字符串的排列;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author: zl
 * @Date: 2019/5/31 12:33
 * @Description: 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 *              例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class Solution {

    public static void main(String[] args) {
        String str = "abc";
        System.out.println(Permutation(str));
    }

    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        // 先将字符串拆分成字符数组，方便后面的全排列操作
        char[] charArr = str.toCharArray();
        // 找出字符串的所有全排列
        permutate(charArr, 0, list);
        // 按字典顺序进行排序（从小到大）。当然这里也可以使用把字符放入TreeMap的做法
        Collections.sort(list);
        return list;
    }

    private static void permutate(char[] str, int index, ArrayList<String> list) {
        if(index == str.length - 1){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length; i++)
                sb.append(str[i]);
            list.add(sb.toString());
        } else {
            for (int i = index; i < str.length; i++) {
                if(swapAccept(str, index, i))  // 检查判断，如果重复的话就跳过此次循环，进行下次递归
                    continue;
                swap(str, index, i);
                permutate(str, index + 1, list);
                swap(str, i, index);    // 递归完毕后再把元素交换回来
            }
        }
    }
    // 判断当前范围内元素有没有和目标元素相同（比如abb，则判断a中有没有元素和b相同，以及ab中是否有元素和b相同）
    private static boolean swapAccept(char[] str, int i, int j) {
        for (int k = i; k < j; k++) {
            if(str[j] == str[k])
                return true;
        }
        return false;
    }

    private static void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}
