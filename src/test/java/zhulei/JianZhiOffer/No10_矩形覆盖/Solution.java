package zhulei.JianzhiOffer.No10_矩形覆盖;

/**
 * @Author: zl
 * @Date: 2019/5/25 15:34
 * @Description: 我们可以用 2*1 的小矩形横着或者竖着去覆盖更大的矩形。请问用 n 个 2*1 的小矩形无重叠地覆盖一个 2*n 的大矩形，总共有多少种方法？
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(RectCover(5));
    }

    // 本质就是上台阶问题，有一次上一步和一次上两步两种方式（对应剑指offer No8）
    public static int RectCover(int target) {
        if(target <= 2)
            return target;
        return RectCover(target - 1) + RectCover(target - 2);
    }
}
