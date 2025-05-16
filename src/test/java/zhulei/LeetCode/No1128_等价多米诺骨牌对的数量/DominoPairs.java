package zhulei.LeetCode.No1128_等价多米诺骨牌对的数量;

import org.junit.jupiter.api.Test;

/**
 * @Author: zl
 * @Date: 2025/5/12 14:58
 * @Description: 给你一组多米诺骨牌 dominoes 。
 *
 *      形式上，dominoes[i] = [a, b] 与 dominoes[j] = [c, d] 等价 当且仅当 (a == c 且 b == d) 或者 (a == d 且 b == c) 。即一张骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌。
 *      在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i, j) 的数量。
 *
 *      输入：dominoes = [[1,2],[1,2],[1,1],[1,2],[2,2]]
 *      输出：3
 *      （这是个组合题，也即下标 (1,2) 和 (2,1) 是同一对骨牌）
 */
public class DominoPairs {

    @Test
    public void test(){
        System.out.println(numEquivDominoPairs(new int[][]{{1,2},{2,1},{1,1},{1,2},{2,2}}));
    }

    public int numEquivDominoPairs(int[][] dominoes) {
        int[] num = new int[100];
        int ret = 0;
        for (int[] domino : dominoes) {
            // 因为条件 1 <= dominoes[i][j] <= 9
            // 考虑拼成一个两位数：例如，[1, 2] 和 [2, 1] 拼接成的两位数都是 12，[3, 4] 和 [4, 3] 拼接成的两位数都是 34
            int val = domino[0] < domino[1] ? domino[0] * 10 + domino[1] : domino[1] * 10 + domino[0];
            // 两个相同的骨牌，记为 1 对，即 A 和 B 相同，一对
            // 三个相同的骨牌，记为 3 对，即 A 和 B 相同，A 和 C 相同，B 和 C 相同。三对
            // 所以 1+2+3 的方式累加就好
            ret += num[val];
            num[val]++;
        }
        return ret;
    }
}
