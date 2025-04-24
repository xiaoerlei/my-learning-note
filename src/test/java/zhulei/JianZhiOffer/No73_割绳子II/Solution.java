package zhulei.JianZhiOffer.No73_割绳子II;

import org.junit.jupiter.api.Test;

/**
 * @Author: zl
 * @Date: 2022/8/15 11:06
 * @Description:
 *      给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1] 。
 *      请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？
 *      例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 *      答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1
 */
public class Solution {

    @Test
    void fun() {
        System.out.println(cuttingRope(120));
    }

    public int cuttingRope(int n) {
        if(n <= 3) {
            return n - 1;
        }
        long res = 1;
        int p = (int) 1e9 + 7;
        while(n > 4) {
            res *= 3;
            res = res % p;
            n -= 3;
        }

        return (int) (res * n % p);
    }
}
