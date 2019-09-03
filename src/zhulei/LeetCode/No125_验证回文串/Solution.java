package zhulei.LeetCode.No125_验证回文串;

import org.junit.jupiter.api.Test;

/**
 * @Author: zl
 * @Date: 2019/8/27 23:06
 * @Description: 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 *          说明：本题中，我们将空字符串定义为有效的回文串。
 *
 *          输入: "A man, a plan, a canal: Panama"
 *          输出: true
 */
public class Solution {

    @Test
    public void function(){
        System.out.println(isPalindrome("`l;`` 1o1 ??;l`"));
    }

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'
                    || s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'
                    || s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
                sb.append(String.valueOf(s.charAt(i)).toLowerCase());
        }

        if(s.length() > 0 && sb.length() == 0)
            return false;

        return sb.toString().equals(sb.reverse().toString());
    }
}
