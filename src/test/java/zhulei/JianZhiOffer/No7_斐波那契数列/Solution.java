package zhulei.JianZhiOffer.No7_斐波那契数列;

/**
 * @Author: zl
 * @Date: 2019/5/25 14:32
 * @Description: 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 *              n<=39
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(Fibonacci(2));
    }

    public static int Fibonacci(int n) {
        if(n == 0)  return 0;
        if(n == 2 || n == 1) return 1;

        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }
}
