package zhulei.JianzhiOffer.No71_n个骰子的点数;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @Author: zl
 * @Date: 2022/8/13 15:56
 * @Description:
 *      把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 *      你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 */
public class Solution {

    @Test
    void fun() {
        System.out.println(Arrays.toString(dicesProbability(2)));
    }

    /**
     * 通常做法是声明一个二维数组dp ，dp[i][j] 代表前 i 个骰子的点数和 j 的概率，并执行状态转移。
     * 而由于 dp[i] 仅由 dp[i-1] 递推得出，为降低空间复杂度，只建立两个一维数组 dp, tmp 交替前进即可
     * @param n
     * @return
     */
    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);
        // n个骰子
        for (int i = 2; i <= n; i++) {
            double[] change = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {
                // 每次不断的叠加概率
                for (int k = 0; k < 6; k++) {
                    change[j + k] += dp[j] / 6.0;
                }
            }
            dp = change;
        }

        return dp;
    }
}
