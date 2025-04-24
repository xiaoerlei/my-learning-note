package zhulei.JianZhiOffer.No48_不用加减乘除做加法;

/**
 * @Author: zl
 * @Date: 2019/6/12 14:21
 * @Description: 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(Add(1, 2));
    }

    /*
        13 + 11 = ？;
        13 的二进制      1 1 0 1                     -----a        13
        11 的二进制      1 0 1 1                     -----b        11

         (a & b) <<1  ->    1 0 0 1 0                   -----d         18
                  a^b  ->     0 1 1 0                   -----e          6

         (d & e) <<1  ->   0 0 1 0 0                  -----f         4
                  d^e  ->  1 0 1 0 0                  -----g        20

         (f & g) <<1  ->   0 1 0 0 0                   ------h        8
                  f^g  ->  1 0 0 0 0                   ------i        16

         (h & i) <<1  ->   0 0 0 0 0                  ------h        0       --------退出循环
                  h^i  ->  1 1 0 0 0                  ------i        24
     */
    public static int Add(int num1,int num2) {
        while (num2 != 0){
            // 相加各位的值，不算进位。异或操作
            int temp = num1 ^ num2;
            // 计算进位值。与操作
            num2 = (num1 & num2) << 1;
            num1 = temp;
        }
        return num1;
    }
}
