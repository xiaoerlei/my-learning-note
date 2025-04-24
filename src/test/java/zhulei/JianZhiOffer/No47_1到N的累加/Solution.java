package zhulei.JianZhiOffer.No47_1到N的累加;

/**
 * @Author: zl
 * @Date: 2019/6/12 13:49
 * @Description: 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(Sum_Solution(10));
    }

    /*
        思路：
            1.需利用逻辑与的短路特性实现递归终止。
            2.当 n == 0 时，(n > 0) && ((sum+=Sum_Solution(n-1)) > 0，只执行前面的判断，为false，然后直接返回 0；
            3.当n > 0时，执行 sum += Sum_Solution(n-1)，实现递归计算 Sum_Solution(n)。
     */
    public static int Sum_Solution(int n) {
        int sum = n;
        boolean flag = (n > 0) && (sum += Sum_Solution(n - 1)) > 0;
        return sum;
    }
}
