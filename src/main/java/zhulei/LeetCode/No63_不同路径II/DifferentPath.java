package zhulei.LeetCode.No63_不同路径II;

/**
 * @Author: zl
 * @Date: 2019/5/22 14:49
 * @Description: 一个机器人位于一个 m x n 网格的左上角
 *             机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角
 *             现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 */
public class DifferentPath {

    public static void main(String[] args) {
        int[][] arr = {{0,0,0}, {0,1,0}, {0,0,0} };
        System.out.println(uniquePathsWithObstacles(arr));
    }

    // 相比62题，多了几处判断
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(obstacleGrid[i][j] == 1)
                    dp[i][j] = 0;
                else if (i == 0 && j == 0)  // 初始化起点
                    dp[i][j] = 1;
                else if(i == 0 && j > 0)    // 防止第一列出现有阻碍的情况。如果第一列有阻碍，则后面的全部记为0
                    dp[i][j] = dp[i][j - 1];
                else if(i > 0 && j == 0)    // 同列，第一行出现阻碍，则出现阻碍后面的都标记为0
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
