package zhulei.JianzhiOffer.No49_把字符串转化为整数;

/**
 * @Author: zl
 * @Date: 2019/6/15 12:05
 * @Description: 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0).
 *          要求不能使用字符串转换整数的库函数, 数值为0或者字符串不是一个合法的数值则返回0。
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(StrToInt("-2147483648"));
    }

    // 一定要注意类型的范围，所以返回值先用long来接收，最后再强制转换回来
    public static int StrToInt(String str) {
        char[] strArr = str.toCharArray();
        long res = 0;
        for (int i = strArr.length - 1, j = 0; i >= 0; i--, j++) {
            if(i == 0 && strArr.length > 1) {
                if(strArr[i] == '-') {
                    res = -res;
                    break;
                } else if(strArr[i] == '+')
                    break;
            }

            if(strArr[i] < '0' || strArr[i] > '9')
                return 0;

            res += (strArr[i] - '0') * Math.pow(10, j);
        }
        return (int) res;
    }
}
