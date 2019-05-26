package zhulei.JianzhiOffer.No11_二进制中1的个数;

/**
 * @Author: zl
 * @Date: 2019/5/26 10:23
 * @Description: 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(NumberOf1(8));
    }

    public static int NumberOf1(int n) {
        int count = 0;
        String binaryNum = Integer.toBinaryString(n);
        for (int i = 0; i < binaryNum.length(); i++) {
            if(binaryNum.charAt(i) == '1')
                count++;
        }
        return count;
    }
}
