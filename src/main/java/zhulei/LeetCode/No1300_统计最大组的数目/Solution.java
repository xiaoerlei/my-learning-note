package zhulei.LeetCode.No1300_统计最大组的数目;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhulei
 * @create 2025-04-23 14:28
 * @Description: 给你一个整数 n 。请你先求出从 1 到 n 的每个整数 10 进制表示下的数位和（每一位上的数字相加），然后把数位和相等的数字放到同一个组中。
 *              请你统计每个组中的数字数目，并返回数字数目并列最多的组有多少个。
 *
 *              输入：n = 13
 *              输出：4
 *              解释：总共有 9 个组，将 1 到 13 按数位求和后这些组分别是：
 *                  [1,10]，[2,11]，[3,12]，[4,13]，[5]，[6]，[7]，[8]，[9]。总共有 4 个组拥有的数字并列最多。
 *                  ([1,10]的位数和都是1，1 = 1 + 0，同理[2,11]可看作是 2 = 1 + 1)
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(countLargestGroup(135));
    }

    public int countLargestGroup(int n) {
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        int maxValue = 0;
        for (int i = 1; i <= n; ++i) {
            int key = 0, cur = i;
            while (cur != 0) {
                key += cur % 10;
                cur /= 10;
            }
            hashMap.put(key, hashMap.getOrDefault(key, 0) + 1);
            maxValue = Math.max(maxValue, hashMap.get(key));
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> kvpair : hashMap.entrySet()) {
            if (kvpair.getValue() == maxValue) {
                ++count;
            }
        }
        return count;
    }
}
