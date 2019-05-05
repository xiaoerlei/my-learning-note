package zhulei.LeetCode.No567_字符串的排列;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zl
 * @Date: 2019/5/5 20:14
 * @Description: 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *              换句话说，第一个字符串的排列之一是第二个字符串的子串。
 */
public class ArrangeOfString {

    public static void main(String[] args) {
        String s1 = "adc";
        String s2 = "dcda";
        System.out.println(checkInclusion(s1, s2));
    }

    /**
     *  首先字符串 s1 的排列的可能性应该是它的长度的阶乘，因为字符串长度可能为10000，所以找出所有排列情况是不太可能。
     *  我们可以转换思路，不要关注排列的形式，而是关注排列中元素的数量关系，
     *  比如 aab，那么，转换为数量关系就是 {a:2,b:1}，因为 S1 长度为3，所以我们的窗口长度也为3，
     *  如果我们在 S2 的找到了这样一个窗口符合出现 a 的次数是两个，b是一个，那么 S2 就是包含 S1 的排列的。
     */
    private static boolean checkInclusion(String s1, String s2) {
        int windowSize = s1.length();
        Map<Character, Integer> orig = new HashMap<>();
        char[] origChar = s1.toCharArray();
        // 首先用一个map来存储s1的每个字符以及出现的次数
        for (int j = 0; j < origChar.length; j++) {
            if(orig.containsKey(origChar[j]))
                orig.put(origChar[j], orig.get(origChar[j]) + 1);
            else
                orig.put(origChar[j], 1);
        }

        for (int i = 0; i <= s2.length() - windowSize; i++) {
            Map<Character, Integer> map = new HashMap<>();
            // 再每次截取与s1长度相同的窗口，然后用另外一个map来统计
            // 不断的滑动窗口
            char[] charArr = s2.substring(i, i + windowSize).toCharArray();
            for (int j = 0; j < charArr.length; j++) {
                if(map.containsKey(charArr[j]))
                    map.put(charArr[j], map.get(charArr[j]) + 1);
                else
                    map.put(charArr[j], 1);
            }
            // 如果两个map里面的元素相同，则匹配成功
            if(map.equals(orig))
                return true;
        }
        return false;
    }
}
