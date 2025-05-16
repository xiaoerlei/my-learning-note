package zhulei.LeetCode.No3306_元音辅音字符串计数II;

import org.junit.jupiter.api.Test;
import java.util.*;

/**
 * @Author: zl
 * @Date: 2025/5/8 14:12
 * @Description: 给你一个字符串 word 和一个 非负 整数 k。
 * 	    返回 word 的 子字符串 中，每个元音字母（'a'、'e'、'i'、'o'、'u'）至少 出现一次，并且 恰好 包含 k 个辅音字母的子字符串的总数
 *
 * 	    示例：
 * 		    输入：word = "ieaouqqieaouqq", k = 1
 * 		    输出：3
 *
 * 		    解释：包含所有元音字母并且恰好含有一个辅音字母的子字符串有：
 * 			    word[0..5]，即 "ieaouq"。
 * 			    word[6..11]，即 "qieaou"。
 * 			    word[7..12]，即 "ieaouq"。
 */
public class CountOfSubstring {

    @Test
    public void test() {
        long res = countOfSubstrings("ieaouqqieaouqq", 1);
        System.out.println(res);
    }

    /*
     * 思路：
     * 1. 某个班级不小于 15 岁的人，可理解为：某个班级 （刚满 15岁）+（不小于 16 岁的人）
     * 2. 换个思路，恰好包含 k 个辅音的子串，可理解为：（恰好包含 k 个辅音的子串） - （恰好包含 k+1 个辅音的子串）
     * 3. 使用滑动窗口的思路，统计恰好包含 k 个辅音的子串的个数
     */
    public long countOfSubstrings(String word, int k) {
       return leastCount(word, k) - leastCount(word, k + 1);
    }

    public long leastCount(String word, int k) {
        int count = 0;
        int index = 0;  // 滑动窗口指针
        Set<Character> wordSet = Set.of(new Character[]{'a', 'e', 'i', 'o', 'u'});
        Map<Character, Integer> yuanCountMap = new HashMap<>();     // 元音字母个数统计
        int fuCount = 0;                                            // 辅音字母个数统计
        for (int i = 0; i < word.toCharArray().length; i++) {
            char rightChar = word.charAt(i);
            if (wordSet.contains(rightChar)) {
                yuanCountMap.merge(rightChar, 1, Integer::sum);
            } else {
                fuCount++;
            }

            // 满足至少有 k 个辅音的子串的个数
            while (yuanCountMap.size() == 5 && fuCount >= k) {
                char leftChar = word.charAt(index);
                if (wordSet.contains(leftChar)) {
                    if (yuanCountMap.merge(leftChar, -1, Integer::sum) == 0) {
                        yuanCountMap.remove(leftChar);
                    }
                } else {
                    fuCount--;
                }
                index++;
            }

            // 当上面条件满足时，后面所有的子字符串均满足
            count += index;
        }

        return count;
    }
}
