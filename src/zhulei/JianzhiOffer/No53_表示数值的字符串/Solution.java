package zhulei.JianzhiOffer.No53_表示数值的字符串;

/**
 * @Author: zl
 * @Date: 2019/6/16 23:21
 * @Description: 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 *          例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class Solution {

    public static void main(String[] args) {
        char[] str = {'+', '5'};
        System.out.println(isNumeric(str));
    }

    /*
        正则表达式：
            []  ： 字符集合
            ()  ： 分组
            ?   ： 重复 0 ~ 1 次
            +   ： 重复 1 ~ n 次
            *   ： 重复 0 ~ n 次
            .   ： 任意字符
            \\. ： 转义后的 .
            \\d ： 数字
     */
    // 本质上就是定义一个按照规定的表达式
    public static boolean isNumeric(char[] str) {
        if(str == null || str.length == 0)
            return false;
        return new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }
}
