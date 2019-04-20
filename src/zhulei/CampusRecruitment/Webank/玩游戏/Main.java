package zhulei.CampusRecruitment.Webank.玩游戏;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author: zl
 * @Date: 2019/4/11 18:55
 * @Description:
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> exit = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        int count = 1;
        for (int i = 0; i < n; i++, count++) {
            if(count % m == 0) {
                exit.add(list.remove(i));
                i--;
            }
            if(list.size() <= 1)
                break;
            if(list.size() - 1 == i)
                i = -1;
        }

        for (int i = 0; i < exit.size(); i++) {
            System.out.print(exit.get(i) + " ");
        }
        System.out.println();
        if(list.size() == 1)
            System.out.println(list.get(0));
    }
}
