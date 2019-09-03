package zhulei.LeetCode.No139_单词拆分;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: zl
 * @Date: 2019/8/27 23:35
 * @Description: 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 *          说明：
 *              拆分时可以重复使用字典中的单词。
 *              你可以假设字典中没有重复的单词。
 *
 *          输入: s = "leetcode", wordDict = ["leet", "code"]
 *          输出: true
 *          解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 *
 *
 */
public class Solution {

    @Test
    public void function(){
        String s = "leetcode";
        List<String> list = Arrays.asList("leet", "code");
        System.out.println(wordBreak(s, list));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;   // 空串为字典的一部分

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                /*
                    状态转移方程在这里可以理解为：
                        输入为leetcode。
                        如果，当i指向s.length()，j指向下标为4的位置，此时j把字符串恰好分割成leet和code两部分；
                        所以，只有当满足字符串leet在字典中，字符串code也在字典中，最后就符合条件返回true；
                        即dp[4]在字典中，wordDict.contains(s.substring(4, s.length())也在字典中

                        当然，这是作为一个整体来看的。子问题也是相同的道理，只有满足子问题的子问题在字典中，子问题才可能在字典中
                 */
                if(dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
