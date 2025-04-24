package zhulei.JianZhiOffer.No52_正则表达式匹配;

import org.junit.jupiter.api.Test;

/**
 * @Author: zl
 * @Date: 2019/6/16 19:12
 * @Description: 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 *          在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class Solution {

    @Test
    void fun() {
        String str = "aaa";
        String pattern = "ab*a*c*a";
        System.out.println(match(str.toCharArray(), pattern.toCharArray()));
        System.out.println(isMatch("aab", "c*a*b"));
    }

    /**
     * 新解法（递归）
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        if (p.length() == 0)  {
            return s.length() == 0;
        }
        // 校验首字母是否匹配
        boolean firstMatch = s.length() != 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        // 判断是否为"*"
        if (p.length() >= 2 && p.charAt(1) == '*') {
            // "*"前字符重复大于等于1次 或 "*"前字符重复0次（不出现）
            // 符合条件出现，则去掉头部，判断下一个字母是否匹配
            // 不符合条件，则去掉 p部分的 字母 + "*" 两个字符长度，继续判断
            return (firstMatch && isMatch(s.substring(1), p)) || isMatch(s, p.substring(2));
        } else {
            // 减去已经匹配成功的头部，继续比较
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }

    /**
     * dp解法
     * @param s
     * @param p
     * @return
     */
    public boolean isMatchDP(String s, String p) {
        int m = s.length() + 1, n = p.length() + 1;
        // 本质上就是看s的前i个字符是否能匹配p的前j个字符
        boolean[][] dp = new boolean[m][n];
        dp[0][0] = true;
        // 初始化首行
        for (int j = 2; j < n; j += 2) {
            dp[0][j] = dp[0][j - 2] && p.charAt(j - 1) == '*';
        }
        // 状态转移
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // '*'表示它前面的字符可以出现任意次，所以这里需要针对不同的情况来区分处理
                if (p.charAt(j - 1) == '*') {
                    // dp[i][j - 2]： 即将字符组合 p[j - 2] * 看作出现 0 次时，能否匹配
                    if (dp[i][j - 2]) {
                        dp[i][j] = true;
                    }
                    // dp[i - 1][j] 且 s[i - 1] = p[j - 2]: 即让字符 p[j - 2] 多出现 1 次时，能否匹配
                    else if (dp[i - 1][j] && s.charAt(i - 1) == p.charAt(j - 2)) {
                        dp[i][j] = true;
                    }
                    // dp[i - 1][j] 且 p[j - 2] = '.': 即让字符 '.' 多出现 1 次时，能否匹配
                    else if (dp[i - 1][j] && p.charAt(j - 2) == '.') {
                        dp[i][j] = true;
                    }
                } else {
                    //  dp[i - 1][j - 1] 且 s[i - 1] = p[j - 1]： 即让字符 p[j - 1] 多出现一次时，能否匹配；
                    if (dp[i - 1][j - 1] && s.charAt(i - 1) == p.charAt(j - 1)) {
                        dp[i][j] = true;
                    }
                    // dp[i - 1][j - 1] 且 p[j - 1] = '.'： 即将字符 . 看作字符 s[i - 1] 时，能否匹配
                    else if (dp[i - 1][j - 1] && p.charAt(j - 1) == '.') {
                        dp[i][j] = true;
                    }
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 原解法（递归）
     * @param str
     * @param pattern
     * @return
     */
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        int strIndex = 0;
        int patternIndex = 0;
        return matchCore(str, strIndex, pattern, patternIndex);
    }

    public boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        // 有效性检验：str到尾，pattern到尾，匹配成功
        if (strIndex == str.length && patternIndex == pattern.length)
            return true;

        // pattern先到尾，匹配失败
        if (strIndex != str.length && patternIndex == pattern.length)
            return false;

        // pattern第2个是*，且字符串第1个跟模式第1个匹配,分3种匹配模式；如不匹配，模式后移2位
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {

            if (strIndex != str.length && (pattern[patternIndex] == str[strIndex] || pattern[patternIndex] == '.')) {
                return matchCore(str, strIndex, pattern, patternIndex + 2) // 模式后移2，视为x*匹配0个字符
                        || matchCore(str, strIndex + 1, pattern, patternIndex + 2) // 视为模式匹配1个字符
                        || matchCore(str, strIndex + 1, pattern, patternIndex); // *匹配1个，再匹配str中的下一个
            } else {
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            }

        }
        // pattern第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
        if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        }
        return false;
    }

}
