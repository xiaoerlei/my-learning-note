package zhulei.LeetCode.No64_最小路径和;

import org.junit.jupiter.api.Test;

/**
 * @Author: zl
 * @Date: 2019/8/5 19:14
 * @Description: 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 *          输入:
 *              [
 *                  [1,3,1],
 *                  [1,5,1],
 *                  [4,2,1]
 *              ]
 *          输出: 7
 *          解释: 因为路径 1→3→1→1→1 的总和最小。
 */

public class Solution {

    @Test
    public void function(){
        int[][] arr = {{1,3,1}, {1,5,1}, {4,2,1}};
        System.out.println(minPathSum(arr));
    }

    public int minPathSum(int[][] grid) {
        int y = grid.length;
        int x = grid[0].length;
        if(y <= 0)
            return 0;

        int[][] dp = new int[y][x];
        dp[0][0] = grid[0][0];  // 赋初值
        for (int i = 1; i < x; i++) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }
        for (int i = 1; i < y; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        // 状态转移公式
        for (int i = 1; i < y; i++) {
            for (int j = 1; j < x; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[y - 1][x - 1];
    }
}
