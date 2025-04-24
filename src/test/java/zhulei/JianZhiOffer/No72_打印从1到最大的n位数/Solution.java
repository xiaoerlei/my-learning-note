package zhulei.JianZhiOffer.No72_打印从1到最大的n位数;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: zl
 * @Date: 2022/8/15 10:02
 * @Description: 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 */
public class Solution {

    @Test
    void fun() {
        System.out.println(Arrays.toString(printNumbers(2)));
    }

    /**
     * 这题本质上应该是考察全排列，所以用回溯的方法来全排列求解
     * @param n
     * @return
     */
    public int[] printNumbers(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            fullPermutation(i, new StringBuilder(), list);
        }
        // 转化输出结果
        return list.stream().mapToInt(x -> x).toArray();
    }

    // 全排列组成集合
    private void fullPermutation(int index, StringBuilder sb, ArrayList<Integer> list) {
        if (index == 0) {
            list.add(Integer.parseInt(sb.toString()));
            return;
        }
        for (int i = 0; i <= 9; i++) {
            // 排除首位数字为0的
            if (i == 0 && sb.length() == 0) {
                continue;
            }
            sb.append(i);
            fullPermutation(index - 1, sb, list);
            sb.delete(sb.length() - 1, sb.length());
        }
    }
}
