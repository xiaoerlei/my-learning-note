package zhulei.LeetCode.No93_复原IP地址;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zl
 * @Date: 2019/8/18 22:58
 * @Description: 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 *      输入: "25525511135"
 *      输出: ["255.255.11.135", "255.255.111.35"]
 */
public class Solution {

    @Test
    public void function(){
        System.out.println(restoreIpAddresses("25525511135"));
    }

    List<String> list = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {

        if("".equals(s))
            return list;

        backTrace(0, s.length(), 0, "", s);

        return list;
    }

    /**
     *
     * @param index 输入字符串的角标索引
     * @param length 输入字符串的长度
     * @param pointCount ip地址的小数点的个数（最多为四个）
     * @param s ip地址的拼接字符串
     * @param str 输入的字符串
     */
    private void backTrace(int index, int length, int pointCount, String s, String str) {
        // 必须满足，满足条件的ip地址正好为输入字符串的长度，以及保证刚好有4个小数点
        if(index == length && pointCount == 4) {
            System.out.println("print" + s);
            list.add(s.substring(0, s.length() - 1));
            return;
        }

        if(pointCount > 4)
            return;

        for (int i = index; i < index + 3; i++) {
            // 必须要满足当前角标要小于输入字符串的长度
            if(i < length) {
                // ip地址的某一段为0的情况
                if (i == index && str.charAt(i) == '0') {
//                    System.out.println("cur:" + s);
                    backTrace(i + 1, length, pointCount + 1, s + '0' + ".", str);
                    break;
                }
                // 正常情况下满足ip分段的情况
                if (Integer.parseInt(str.substring(index, i + 1)) <= 255) {
//                    System.out.println("before:" + s);
                    // 注意，参数index这个地方应该选用i + 1，而不是index + 1。因为循环是用index作为起点，所以如果用index + 1会改变递归的指针指向
                    backTrace(i + 1, length, pointCount + 1, s + str.substring(index, i + 1) + ".", str);
//                    System.out.println("after:" + s);
                }
            }
        }
    }
}
