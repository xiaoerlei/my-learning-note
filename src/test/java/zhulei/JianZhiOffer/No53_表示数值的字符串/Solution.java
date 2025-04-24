package zhulei.JianZhiOffer.No53_表示数值的字符串;

import org.junit.jupiter.api.Test;

/**
 * @Author: zl
 * @Date: 2019/6/16 23:21
 * @Description: 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 *          例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class Solution {

    @Test
    void fun() {
        char[] str = {'+', '5'};
        System.out.println(isNumeric(str));
        System.out.println(isNumber("+3.1.416"));
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
    public boolean isNumeric(char[] str) {
        if(str == null || str.length == 0)
            return false;
        return new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }

    /**
     * 正常思路解法
     * @param s
     * @return
     */
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        boolean isNum = false, isDot = false, ise_or_E = false;
        // 删除字符串头尾的空格，转为字符数组，方便遍历判断每个字符
        char[] str = s.trim().toCharArray();
        for (int i = 0; i < str.length; i++) {
            // 判断当前字符是否为 0-9 的数位、 遇到小数点、遇到 e 或 E
            if (str[i] >= '0' && str[i] <= '9') {
                isNum = true;
            } else if (str[i] == '.') { //
                // 小数点之前可以没有整数，但是不能重复出现小数点、或出现 e 或 E
                if (isDot || ise_or_E) {
                    return false;
                }
                // 标记已经遇到小数点
                isDot = true;
            } else if (str[i] == 'e' || str[i] == 'E') {
                // ‘e’或'E'前面必须有整数，且前面不能重复出现‘e’或'E'
                if (!isNum || ise_or_E) {
                    return false;
                }
                // 标记已经遇到 e 或 E
                ise_or_E = true;
                // 重置isNum，因为 e 或 E 之后也必须接上整数，防止出现 123e 或者 123e+ 的非法情况
                isNum = false;
            } else if (str[i] == '-' || str[i] == '+') {
                // 正负号只可能出现在第一个位置，或者出现在 e 或 E 的后面一个位置
                if (i != 0 && str[i - 1] != 'e' && str[i - 1] != 'E') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return isNum;
    }
}
