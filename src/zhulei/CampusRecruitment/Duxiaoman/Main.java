package zhulei.CampusRecruitment.Duxiaoman;

import java.util.Scanner;

/**
 * @Author: zl
 * @Date: 2019/4/28 20:28
 * @Description:
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] inputArr = new int[n];
        String[] strArr = new String[n];
        for (int i = 0; i < n; i++) {
            inputArr[i] = sc.nextInt();
            strArr[i] = String.valueOf(inputArr[i]);
        }

        for (int i = 0; i < n; i++) {
            int count = 0;
            char[] charArr = strArr[i].toCharArray();
            for (int j = 0; j < charArr.length; j++) {
                if(charArr[j] - '0' == 0) {
                    count++;
                    continue;
                }

                if(inputArr[i] % (charArr[j] - '0') == 0)
                    count++;
            }

            if(count == 0)
                System.out.println("S");
            else if(count == charArr.length)
                System.out.println("G");
            else
                System.out.println("H");
        }
    }
}
