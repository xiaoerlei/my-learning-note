package zhulei.CampusRecruitment.Webank.跳格子;

import java.util.Scanner;

/**
 * @Author: zl
 * @Date: 2019/4/11 20:34
 * @Description:
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] arrN = new int[T];
        for (int i = 0; i < T; i++) {
            arrN[i] = sc.nextInt();
        }

        for (int i = 0; i < T; i++) {
            int count = 0;
            int flag = 0;
            while (arrN[i] != 1){
                if(arrN[i] % 2 == 0){
                    arrN[i] /= 2;
                } else {
                    arrN[i] = 3 * arrN[i] + 1;
                }
                count++;

                if(count > 10000000){
                    System.out.println(-1);
                    flag = 1;
                    break;
                }
            }
            if(flag != 1)
                System.out.println(count);
        }
    }
}
