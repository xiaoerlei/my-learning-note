package zhulei.LeetCode.No392_判断子序列;

import org.junit.jupiter.api.Test;

/**
 * @Author: zl
 * @Date: 2019/9/1 16:26
 * @Description: 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *          你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 *          字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
 *          （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 *          示例 1: s = "abc", t = "ahbgdc"
 *          返回 true.
 *
 *          示例 2: s = "axc", t = "ahbgdc"
 *          返回 false.
 *
 */
public class Solution {

    @Test
    public void function(){
        String s = "axc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }

    public boolean isSubsequence(String s, String t) {
        if("".equals(s))
            return true;

        int sIndex = 0;
        for (int i = 0; i < t.length(); i++) {
            if(s.charAt(sIndex) == t.charAt(i))
                sIndex++;

            if(sIndex == s.length())
                return true;
        }

        return false;
    }
}
