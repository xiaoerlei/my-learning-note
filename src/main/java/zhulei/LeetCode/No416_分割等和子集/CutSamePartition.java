package zhulei.LeetCode.No416_分割等和子集;

/**
 * @Author: zl
 * @Date: 2019/4/7 0:39
 * @Description: 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 *   转化为0-1背包问题：c[i][m] = max{c[i - 1][m-w[i]] + pi ,c[i-1][m]}
 *              可容纳的最大容量（j）   1   2   3   4   5   6   7   8   9   10  11
 *       数组中的元素（i）
 *                  1                  1   1   1   1   1   1   1   1   1   1   1
 *                  5                  1   1   1   1   5   6   6   6   6   6   6
 *                  11                 1   1   1   1   5   6   6   6   6   6   11
 *                  5                  1   1   1   1   5   6   6   6   6   10  11
 *
 *                  dp[3][9] = dp[i][j] = Max(dp[i - 1][j], weight[i - 1] + dp[i - 1][j - weight[i - 1]]) = 10
 *                  其中，Max(上一个单元格的值， 当前的值 + 剩余空间的价值);
 *                  dp[3][9]上一个单元格的值dp[2][9] = 6，当前的值weight[3] = 5，剩余空间的价值dp[2][9 - 5] = 5
 *                  所以，p[3][9] = Max(6, 5 + 5) = 10
 *
 *                  同理，dp[3][10] = Max(dp[i - 1][j], weight[i - 1] + dp[i - 1][j - weight[i - 1]])
 *                      = Max(dp[2][10] ， weight[3] + dp[2][10 - 10]) = Max(11, 5 + 6) = 11
 */
public class CutSamePartition {

    public static void main(String[] args) {
//        int[] arr = {1, 5, 11, 5};
        int[] arr = {1, 3, 4, 7, 5, 2, 8, 6};
        System.out.println(canPartition(arr));

    }

    public static boolean canPartition(int[] nums) {
        int sum = 0 ;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i] ;
        }
        // 如果数组的综合为奇数，那么必定是不能等和分割的
        if((sum & 1) == 1){
            return false ;
        }
        int n = sum / 2 ;
        int[] dp = new int[n + 1] ; // 因为只用判断是否可以等和分割，所以用一维数组保存即可
        for(int i = 0; i < nums.length; i++){
            for(int j = n; j >= nums[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]) ;
            }
        }
        return dp[n] == n;
    }

    // 利用0-1背包的动态规划方案来解决问题，并返回最后拆分完的数组
    public static boolean backpacketProblem(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1)
            return false;

        int[][] dp = new int[nums.length + 1][sum / 2 + 1];
        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 1; j < sum / 2 + 1; j++) {
                if(j < nums[i - 1])
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i - 1]] + nums[i - 1]);
            }

        }

        return dp[nums.length][sum / 2] == sum / 2;
    }

}
