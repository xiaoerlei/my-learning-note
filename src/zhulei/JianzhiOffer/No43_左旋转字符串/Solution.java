package zhulei.JianzhiOffer.No43_左旋转字符串;

/**
 * @Author: zl
 * @Date: 2019/6/11 10:12
 * @Description: 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 *              对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 *              例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(LeftRotateString("abcXYZdef", 3));

        System.out.println(otherSolution("abcXYZdef", 3));
    }

    // 暴力求解思路
    public static String LeftRotateString(String str, int n) {
        if(str.length() < n)
            return "";

        String partOne = str.substring(0, n);
        String partTwo = str.substring(n);

        return partTwo + partOne;
    }

    // 两次反转
    /*
        举例：
                                        str      1 2 3 4 5       n = 3
            第一次全部反转                        5 4 3 2 1
            第二次 0 到 n - 1 反转                4 5 3 2 1
            第三次 n - 1 到 length - 1 反转       4 5 1 2 3
     */
    public static String otherSolution(String str, int n) {
        StringBuilder sb = new StringBuilder(str);
        reverse(sb, 0, str.length());
        reverse(sb, 0, str.length() - n);
        reverse(sb, str.length() - n, str.length());
        return sb.toString();
    }

    private static void reverse(StringBuilder sb, int start, int end) {
        sb.replace(start, end, new StringBuilder(sb.substring(start , end)).reverse().toString());
    }
}
