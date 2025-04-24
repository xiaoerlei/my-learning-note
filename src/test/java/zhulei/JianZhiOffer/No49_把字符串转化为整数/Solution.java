package zhulei.JianZhiOffer.No49_把字符串转化为整数;

import org.junit.jupiter.api.Test;

/**
 * @Author: zl
 * @Date: 2019/6/15 12:05
 * @Description: 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0).
 *          要求不能使用字符串转换整数的库函数, 数值为0或者字符串不是一个合法的数值则返回0。
 */
public class Solution {

    @Test
    void fun() {
        System.out.println(StrToInt("-2147483648"));
        System.out.println(strToInt("-91283472332"));
    }

    // 一定要注意类型的范围，所以返回值先用long来接收，最后再强制转换回来
    public int StrToInt(String str) {
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

    /**
     * leetcode题源：https://leetcode.cn/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/
     * 与原本的题目相较有变化，部分条件需要额外做判断处理
     *
     * @param str
     * @return
     */
    public int strToInt(String str) {
        char[] strArr = str.trim().toCharArray();
        if (strArr.length == 0) {
            return 0;
        }
        // 因为需要累乘，所以boundary要用最大值除10
        int res = 0, index = 1, boundary = Integer.MAX_VALUE / 10;
        // 是否为负数
        boolean isSign = false;
        if (strArr[0] == '-') {
            isSign = true;
        }
        // index表示开始标识判断的字符串角标，即index=0表示是否需要从第一位开始判断
        if (strArr[0] != '-' && strArr[0] != '+') {
            index = 0;
        }
        for (int i = index; i < strArr.length; i++) {
            if (strArr[i] < '0' || strArr[i] > '9') {
                break;
            }
            // 越界处理
            if (res > boundary || res == boundary && strArr[i] > '7') {
                return isSign ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            // strArr[i] - '0' 为计算当前char对应的数字
            res = res * 10 + (strArr[i] - '0');
        }
        return isSign ? -res : res;
    }
}
