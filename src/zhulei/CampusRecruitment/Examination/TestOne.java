package zhulei.CampusRecruitment.Examination;

import java.util.*;

public class TestOne {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();
        int[] price = new int[N];
        int[] weight = new int[N];
        for (int i = 0; i < N; i++) {
            price[i] = sc.nextInt();
            weight[i] = sc.nextInt();
        }

        int[] dp = new int[V + 1];
        for (int i = 1; i < N; i++) {
            for (int j = V; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + price[i]);
            }
        }

        System.out.println(dp[V]);
        sc.close();
    }

}

