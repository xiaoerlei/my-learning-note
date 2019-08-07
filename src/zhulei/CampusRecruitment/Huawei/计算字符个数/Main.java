package zhulei.CampusRecruitment.Huawei.计算字符个数;

import java.util.Scanner;

/**
 * @Author: zl
 * @Date: 2019/7/16 0:04
 * @Description:
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String desStr = null;
        String aimStr = null;
        while(sc.hasNext()){
            desStr = sc.nextLine();
            aimStr = sc.nextLine();
            int count = 0;
            for(int i = 0; i < desStr.length(); i++){
                if((desStr.charAt(i) + "").equalsIgnoreCase(aimStr))
                    count++;
            }

            System.out.println(count);
        }
    }

}
