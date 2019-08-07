package zhulei.CampusRecruitment.Huawei.字符串最后一个单词的长度;


import java.util.Scanner;

/**
 * @Author: zl
 * @Date: 2019/7/15 23:39
 * @Description:
 */
public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = null;
        while(sc.hasNextLine()){
            str = sc.nextLine();
            String[] worldArr = str.split(" ");
            System.out.println(worldArr[worldArr.length - 1].length());
        }
    }
}
