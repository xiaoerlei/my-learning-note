package zhulei.Arithmetic.DynamicProgramming.割绳子;

/**
 * @Author: zl
 * @Date: 2019/6/25 10:24
 * @Description: 给你一根长度为n的绳子，请把绳子剪成m段 (m和n都是整数，n>1并且m>1)每段绳子的长度记为k[0],k[1],…,k[m].
 *          请问k[0]k[1]…*k[m]可能的最大乘积是多少？
 *          例如，当绳子的长度为8时，我们把它剪成长度分别为2,3,3的三段，此时得到的最大乘积是18.
 */
public class CutRope {

    public static void main(String[] args) {
        System.out.println(maxProduct(8));
    }

    private static int maxProduct(int length) {
        if(length < 1) return 0;
        if(length <= 3) return length - 1;

        // 创建数组存储子问题最优解
        // 数组中的第i个元素表示把长度为i的绳子剪成若干段后各段长度乘积的最大值。
        int[] dp = new int[length+1];  // 0 - length， 共length + 1
        // 这些情况下，不剪的时候长度比剪的时候长，所以作为初始条件
        // 这些都是子问题最优解,因为是子问题，所以这些情况可以不剪，因为可以看成它是分割后的一部分
        dp[1] = 1; dp[2] = 2; dp[3] = 3;
        for(int i = 4; i <= length; i++){
            int max = 0;
            for(int j = 1; j <= length / 2; j++){
                int temp = dp[j] * dp[i - j];   // 状态转移方程
                if(temp > max)
                    max = temp;
            }
            dp[i] = max;
        }
        return dp[length];
    }


}
