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

    /*
        记录的全排列就是所有可能出现在第一个位置的记录与剩下所有元素的全排列。

        （1）确定第一位的字符
                数组str 从 start 到 end 的所有记录都可以出现在第一个位置，所以直接一个for循环，考虑了这所有的情况。
                在for循环中，swap 方法就是交换 i 和 start 位置的数，保证当前i指向的记录出现在第一个位置，也就是 start 指向的位置
        （2）剩下的记录继续做全排列
                这个就是一个递归函数的调用，只需要修改起始位置，也就是 start+1，
                因为 start 的位置已经放了记录，所以只需要继续做从 start+1 到 end 的全排列即可
        （3）swap方法
                因为数组传递的是地址，所以所有的修改对所有人都是共享的，
                因此为了保证每一次的交换不会对下一次的交换产生影响，要重新交换一下位置，也就是复原，不然对下一次的交换就有影响了

        最后，递归的终止条件就是当 start==end，也就是只有一个记录需要做全排列，也就是到了最后一个记录，这就是全排列的一种情况，输入本次的记录，也就是数组str即可。
     */
    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        // 先将字符串拆分成字符数组，方便后面的全排列操作
        char[] charArr = str.toCharArray();
        // 找出字符串的所有全排列
        permutate(charArr, 0, charArr.length - 1, list);
        // 按字典顺序进行排序（从小到大）。当然这里也可以使用把字符放入TreeMap的做法
        Collections.sort(list);
        return list;
    }

    private static void permutate(char[] str, int start, int end, ArrayList<String> list) {
        if(start == end){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <=  end; i++)
                sb.append(str[i]);
            list.add(sb.toString());
        } else {
            for (int i = start; i <= end; i++) {
                if(swapAccept(str, start, i))  // 检查判断，如果重复的话就跳过此次循环，进行下次递归
                    continue;
                swap(str, start, i);
                permutate(str, start + 1, end, list);
                swap(str, i, start);    // 递归完毕后再把元素交换回来
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
