package zhulei.CampusRecruitment.Kuaishou.机器人走格子;

import java.util.Scanner;

/**
 * @Author: zl
 * @Date: 2019/3/31 15:02
 * @Description: 地上有一个m行n列的方格。
 *              一个机器人从坐标0，0的格子开始移动，每一次只能向左、右、上、下四个方向移动一格，
 *              但是不能进入行坐标和列坐标位数之和大于k的格子。
 *              例如：k=18，机器人进入方格（35，37），因为3+5+3+7=18
 *                  但是，不能进入（35，38），因为3+5+3+8=19
 *              请问该机器人能够达到多少个格子？
 *
 *              输入：m、n、k
 *              输出：一个正整数，代表机器人能够到达的格子数量
 */
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();

        int count = theGirdCountOfArrival(m, n, k);
        System.out.println(count);
        sc.close();
    }

    private static int theGirdCountOfArrival(int m, int n, int k) {

        return 0;
    }
}
