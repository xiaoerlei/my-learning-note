package zhulei.LeetCode.No441_排列硬币;

/**
 * @Author: zl
 * @Date: 2019/5/22 15:27
 * @Description: 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
 *              给定一个数字 n，找出可形成完整阶梯行的总行数。
 *              n 是一个非负整数，并且在32位有符号整型的范围内。
 */
public class ArrangeCoins {

    public static void main(String[] args) {
        System.out.println(arrangeCoins(10));

        System.out.println(otherSolution(8));
    }

    public static int arrangeCoins(int n){
        int num = 1;
        while (n - num > 0){
            n -= num;
            num++;
        }

        return num == n ? num : num - 1;
    }

    // 数学方法求解
    // 根据规律得到不等式 x * (x + 1) / 2 <= n ,求解x的值即可
    // 最后解得 x <= (-1 + Math.sqrt(8 * n + 1)) / 2
    public static int otherSolution(int n) {
        return (int) ((-1 + Math.sqrt(8 * n + 1)) / 2);
    }
}
