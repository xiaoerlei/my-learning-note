package zhulei.CampusRecruitment.Examination;

import java.util.Scanner;

public class TestTwo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String curNum = sc.nextLine();
            String[] numStr = curNum.substring(1, curNum.length() - 1).split(",");
            int[] numInt = new int[numStr.length];
            for (int i = 0; i < numStr.length; i++) {
                numInt[i] = Integer.parseInt(numStr[i]);
            }

            int res = binarySearch(numInt) + 1;
            System.out.println(res);
        }

        sc.close();
    }

    private static int binarySearch(int[] numInt) {
        if(numInt.length == 0)
            return -1;

        return binarySearch(0, numInt.length - 1, numInt);
    }

    private static int binarySearch(int left, int right, int[] num) {
        int mid = left + (right - left) / 2;

        if(left > right)
            return -1;

        if(num[mid] > 19)
            return binarySearch(left, mid - 1, num);
        else if(num[mid] < 19)
            return binarySearch(mid + 1, right, num);
        else
            return mid;

    }


}
