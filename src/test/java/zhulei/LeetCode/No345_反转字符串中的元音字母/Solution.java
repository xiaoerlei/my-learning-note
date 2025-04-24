package zhulei.LeetCode.No345_反转字符串中的元音字母;

import org.junit.jupiter.api.Test;
import java.util.*;

/**
 * @Author: zl
 * @Date: 2019/8/25 22:44
 * @Description: 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 *          输入: "leetcode"
 *          输出: "leotcede"
 */
public class Solution {

    @Test
    public void function(){
        System.out.println(reverseVowels("aA"));
        System.out.println(reverseVowel("leetcode"));
    }

    // 通过将元音字母压栈，最后出栈的时候可以使元音字母反转
    public String reverseVowels(String s) {
        Stack<String> strStack = new Stack<>();

        List<Character> list = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        for (int i = 0; i < s.length(); i++) {
            if(list.contains(s.charAt(i)))
                strStack.push(String.valueOf(s.charAt(i)));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(list.contains(s.charAt(i)))
                sb.append(strStack.pop());
            else
                sb.append(String.valueOf(s.charAt(i)));
        }

        return sb.toString();
    }

    // 双指针法
    public String reverseVowel(String s) {
        List<Character> list = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        // 定义前后指针
        int left = 0, right = s.length() - 1;
        char[] charArr = s.toCharArray();
        StringBuilder res = new StringBuilder(s);
        do {
            // right > left 一定要在前面判断，以防数组越界
            while(right > left && !list.contains(charArr[left]))
                left++;

            while(right > left && !list.contains(charArr[right]))
                right--;

            if(right > left) {
                res.setCharAt(left, charArr[right]);
                res.setCharAt(right, charArr[left]);
                right--;
                left++;
            }
        } while (left < right);

        return res.toString();
    }
}
