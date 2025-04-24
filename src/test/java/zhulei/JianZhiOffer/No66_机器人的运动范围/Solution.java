package zhulei.JianZhiOffer.No66_机器人的运动范围;

/**
 * @Author: zl
 * @Date: 2019/6/23 22:35
 * @Description: 地上有一个m行和n列的方格。
 *          一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 *          例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
 *          请问该机器人能够达到多少个格子？
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(movingCount(18, 35 , 37));
    }

    public static int movingCount(int threshold, int rows, int cols) {
        int[][] flag = new int[rows][cols];     // flag数组记录走过的路径，走过的话就置为1
        return trace(0, 0, rows, cols, flag, threshold);
    }

    private static int trace(int X, int Y, int rows, int cols, int[][] flagArr, int threshold) {
        // 如果走到走过的路，过着超过阈值，返回0
        if(X < 0 || X >= rows || Y < 0 || Y >= cols || flagArr[X][Y] == 1 || colsSum(X) + colsSum(Y) > threshold)
            return 0;
        // 对走过的路进行标记
        flagArr[X][Y] = 1;
        // 对上下左右四个方向分别进行走动
        return trace(X - 1, Y, rows, cols, flagArr, threshold) + trace(X, Y - 1, rows, cols, flagArr, threshold)
                + trace(X + 1, Y, rows, cols, flagArr, threshold) + trace(X, Y + 1, rows, cols, flagArr, threshold) + 1;
    }
    // 计算阈值
    private static int colsSum(int num) {
        int sum = 0;
        char[] arrNum = (num + "").toCharArray();
        for (int i = 0; i < arrNum.length; i++) {
            sum += Integer.parseInt(arrNum[i] + "");
        }
        return sum;
    }
}
