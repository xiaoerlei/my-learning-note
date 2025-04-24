package zhulei.JianZhiOffer.No31_整数中1出现的次数;

import org.junit.jupiter.api.Test;

/**
 * @Author: zl
 * @Date: 2019/5/31 15:33
 * @Description: 求出1~13的整数中1出现的次数,
 *          并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 *          ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 */
public class Solution {

    @Test
    void fun() {
        System.out.println(countDigitOne(13));
        System.out.println(NumberOf1Between1AndN_Solution(13));
    }

    /**
     * 将 1 ~ n 的个位、十位、百位、...的 1 出现次数相加，即为 1 出现的总次数
     * 设当前位cur，地位low，高位high，以及 位因子pow(10, i)
     * 跟别根据cur位的数值：0、1、2-9三种情况来做处理
     *
     * @param n
     * @return
     */
    public int countDigitOne(int n) {
        int res = 0;
        int high = n / 10, cur = n % 10, low = 0, digit = 1;
        while(high != 0 || cur != 0) {
            // 分别对cur为0、1、2-9三种情况来做处理
            if(cur == 0) {
                res += high * digit;
            }
            else if(cur == 1) {
                res += high * digit + low + 1;
            }
            else {
                res += (high + 1) * digit;
            }
            // 对cur、low、high和digit进行移位
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }

    // 暴力求解（二刷的时候来优化）
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++)
            sb.append(i);

        for (int i = 0; i < sb.length(); i++)
            if(sb.charAt(i) == '1')
                count++;

        return count;
    }
}
