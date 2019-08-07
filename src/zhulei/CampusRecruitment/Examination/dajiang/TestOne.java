package zhulei.CampusRecruitment.Examination.dajiang;

import java.util.Scanner;

/**
 * @Author: zl
 * @Date: 2019/8/6 19:01
 * @Description: 有许多程序员都热爱玩游戏游戏，而小J自称为游戏王，曾玩过几百种游戏，几乎所有能玩到的游戏大作都玩遍了。
 *      随着时间的推移，他发觉已经没有游戏可以让他玩了！于是他想改玩一些古老的游戏，以成为真正的“游戏王”。
 *      他希望在接下来的一段时间内将过去出的游戏全部玩一遍，但是毕竟时间有限，因此他感到很苦恼。于是他给每个游戏标上一个成就值，同时估算了完成这些游戏所需要的时间。
 *      现在他只有X天时间。而每个游戏一旦开始玩，至少需要玩一天才能够停下来。那么，他所玩完的游戏的成就值之和最大能达到多少呢？（每个游戏必须玩完才能取得成就值。）
 *
 *          第一行输入case数T（0<T<20）。对于每个case，第一行输入游戏的数目N(0<N<11)，总时间X(0<X<1000)用空格分隔。
 *          第二行到第N+1行每行输入游戏的成就值Ai(0<Ai<10000)，所需要花费时间Bi(0<Bi<10000)。
 *
 *       输入    2
 *              2 2
 *              10 1
 *              20 2
 *              3 4
 *              10 2
 *              18 3
 *              10 2
 *
 *       输出    20
 *              20
 */
public class TestOne {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();                   // 总case数
        int[][] countAndTime = new int[T][2];   // 初始化每个case

        for (int i = 0; i < T; i++) {
            countAndTime[i][0] = sc.nextInt();
            countAndTime[i][1] = sc.nextInt();

            // 遍历游戏数，用01背包思路来找到最大成就值
            int gameCount = countAndTime[i][0];
            int timeSpend = countAndTime[i][1];
            int[][] gameProudAndTimeSpend = new int[gameCount][2];
            for (int j = 0; j < gameCount; j++) {
                gameProudAndTimeSpend[j][0] = sc.nextInt();
                gameProudAndTimeSpend[j][1] = sc.nextInt();
            }

            // 动态规划
            int[][] dp = new int[gameCount + 1][timeSpend + 1];      // 用于记录消耗的时间所获取的最大成就值
            // 循环每次游戏（每个游戏消耗的时间）
            for (int x = 1; x <= gameCount; x++) {
                // 循环每次的时间消耗，在每次循环中选取到最大成就值
                for (int y = 1; y <= timeSpend; y++)
                    if(gameProudAndTimeSpend[x - 1][1] > y)     // 如果 当前游戏所消耗的时间 小于 当前的时间消耗数。记录之前最大的成就值
                        dp[x][y] = dp[x - 1][y];
                    else                                        // gameProudAndTimeSpend[x - 1][1]为当前游戏所花费的时间
                        dp[x][y] = Math.max(dp[x - 1][y], gameProudAndTimeSpend[x - 1][0] + dp[x][y - gameProudAndTimeSpend[x - 1][1]]);
            }

            System.out.println(dp[gameCount][timeSpend]);
        }
    }


}
