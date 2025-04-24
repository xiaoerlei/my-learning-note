package zhulei.JianZhiOffer.No74_数字序列中某一位的数字;

import org.junit.jupiter.api.Test;

/**
 * @Author: zl
 * @Date: 2022/8/15 16:18
 * @Description:
 */
public class Solution {

    @Test
    void fun() {
        System.out.println(findNthDigit(100));
    }

    /**
     * 迭代 + 求整 / 求余
     *      数字范围（start-end）    位数（digit）      数字数量     数位数量（count）
     *      1-9                     1                   9           9
     *      10-99                   2                   90          180
     *      100-999                 3                   900         2700（9 * start * digit）
     *
     * @param n
     * @return
     */
    public int findNthDigit(int n) {
        // digit为位数，十位百位；start为位数起始数字；count为数位数量
        int digit = 1;
        long start = 1, count = 9;
        // 确定所求数位的所在数字的位数
        while (n > count) {
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        // 确定所求数位所在的数字（0、1、2.....9、10、11。即具体的数字）
        long num = start + (n - 1) / digit;
        // 确定所求数位在 num 的哪一数位
        int index = (n - 1) % digit;
        return Long.toString(num).charAt(index) - '0';
    }

}
