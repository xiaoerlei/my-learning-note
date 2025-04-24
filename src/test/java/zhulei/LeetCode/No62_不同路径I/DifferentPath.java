package zhulei.LeetCode.No62_不同路径I;

/**
 * @Author: zl
 * @Date: 2019/5/22 11:21
 * @Description: 一个机器人位于一个 m x n 网格的左上角
 *              机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角
 *              问总共有多少条不同的路径？
 */

public class DifferentPath {

    public static void main(String[] args) {
        System.out.println(uniquePaths(7, 3));

        System.out.println(uniquePath(7, 3));
    }

    // 典型的dp问题
    // 每一个（m，n）都依赖于（m，n - 1）和（m - 1，n）的值，即当前点的值依赖于左边和上面的值
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static int uniquePath(int m, int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = 1;
        }
        // 每次滚动对数组的更新
        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }

        return dp[n];
    }
}
