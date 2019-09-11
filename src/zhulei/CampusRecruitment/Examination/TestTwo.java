package zhulei.CampusRecruitment.Examination;

import java.util.*;

public class TestTwo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] items = new int[n];
        for (int i = 0; i < n; i++) {
            items[i] = sc.nextInt();
        }
        int sumMoney = sc.nextInt();
        Arrays.sort(items);
        int[] dp = new int[sumMoney + 1];
        for (int item : items) {
            for (int i = item; i <= sumMoney; i++) {
                if (i == item)
                    dp[i] = 1;
                else if (dp[i] == 0 && dp[i - item] != 0)
                    dp[i] = dp[i - item] + 1;
                else if (dp[i - item] != 0)
                    dp[i] = Math.min(dp[i], dp[i - item] + 1);
            }
        }
        int res = dp[sumMoney] == 0 ? -1 : dp[sumMoney];
        System.out.println(res);
        sc.close();
    }

}
