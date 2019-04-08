package zhulei.CampusRecruitment.Kuaishou.转化为二进制;

import java.util.Scanner;

/**
 * @Author: zl
 * @Date: 2019/3/31 16:30
 * @Description: 将十进制数转化为二进制数，然后输出二进制数中1的个数。
 *              例如：输入整数5，输出字符串2
 */
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        String res = toBinary(n);
        String res = apiBinaryMethod(n);
        System.out.println(res);
        sc.close();
    }

    // 调用Integer的toBinaryString方法来解决
    private static String apiBinaryMethod(int n) {
        int count = 0;
        String str = Integer.toBinaryString(n);
        for (int i = 0; i < str.length(); i++) {
            if(str.toCharArray()[i] == '1')
                count++;
        }
        return String.valueOf(count);
    }

    // 不断除2，来2进制中1的个数
    private static String toBinary(int n) {
        int count = 0;
        while(n / 2 > 0 || n == 1){
            if(n % 2 == 1)
                count++;
            n = n / 2;
        }
        return String.valueOf(count);
    }
}
