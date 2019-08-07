package zhulei.LeetCode.No91_解码方法;

import org.junit.jupiter.api.Test;

/**
 * @Author: zl
 * @Date: 2019/8/5 21:58
 * @Description: 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *                          'A' -> 1
 *                          'B' -> 2
 *                            ...
 *                          'Z' -> 26
 *               给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 *               输入: "12"                                           输入: "226"
 *               输出: 2                                              输出: 3
 *               解释: 它可以解码为 "AB"（1 2）或者 "L"（12）.            解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6)
 */

public class Solution {

    @Test
    public void function(){
        System.out.println(numDecodings("2226"));
    }

    // 本质上就是一个斐波那契数列：F(n) = F(n - 1) + F(n - 2)。
    public int numDecodings(String s) {
        if(s.length() == 0 || s.charAt(0) == '0')
            return 0;

        int[] dp = new int[s.length() + 1];
        dp[0] = dp[1] = 1;

        /*
            执行过程（以226为例）：
                    第一位数为 2，所以此时记录dp[1] = 1的
                    第二位数为 2，这个时候就需要进行判断了：
                                2 不等于 0，所以是合法数，就有dp[2] = dp[2] + dp[1] = 0 + 1 = 1
                                2 又是小于 3 的，即可以组成编码数。而 2 的前一位数字，也就是第一位数字 2，所以dp[2] = dp[2] + dp[0] = 1 + 1 = 2
                    第三位数为 6，同样需要进行判断：
                                6 不等于 0，所以是合法数，就有dp[3] = dp[3] + dp[2] = 0 + 2 = 2（保留之前前两位数编码的可能性）
                                6 又是大于 2 的，所以不能组成编码数。进而判断得到6是在1-6之间的，所以可以组成新得编码dp[3] = dp[3] + dp[1] = 2 + 1 = 3


            注：dp[i] += dp[i - 1] 和 dp[i] += dp[i - 2]; 分别是满足两种条件的情况，对应于满足条件的斐波那契数列
         */
        for (int i = 2; i <= s.length(); i++) {
            // 如果该位不为'0'，说明该位单独成字母合法
            if(s.charAt(i - 1) != '0')
                dp[i] += dp[i - 1];
            // 如果后两位能组成"1x"（x为任意数字）或者"2x"（x小于7），说明最后两位组成字母合法
            if(s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) >= '0' && s.charAt(i - 1) <= '6'))
                dp[i] += dp[i - 2];
        }

        return dp[s.length()];
    }
}
