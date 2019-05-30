package zhulei.JianzhiOffer.No19_瞬时间打印矩阵;

import java.util.ArrayList;

/**
 * @Author: zl
 * @Date: 2019/5/29 19:25
 * @Description: 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 *          例如，如果输入如下 4 X 4 矩阵： 1  2  3  4
 *                                        5  6  7  8
 *                                       9  10 11 12
 *                                      13 14 15 16
 *          则依次打印出数字：1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class Solution {

    public static void main(String[] args) {
//        int[][] arr = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
//        int[][] arr = {{1}, {5}, {9}, {13}};
        int[][] arr = {{1,2,3,4}, {5,6,7,8}};
        System.out.println(printMatrix(arr));
    }

    /*
        思路：
            1、分别设置四个边界值，分别代表矩阵的四个角
            2、每一次顺时针旋转，四个边界值都需要各自+1和-1
            3、注意边界条件
     */
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        int XStart = 0, XStop = matrix.length - 1;
        int YStart = 0, YStop = matrix[0].length - 1;

        ArrayList<Integer> list = new ArrayList<>();
        while (XStart <= XStop && YStart <= YStop){
            for (int i = YStart; i <= YStop; i++)
                list.add(matrix[XStart][i]);

            for (int i = XStart + 1; i <= XStop; i++)
                list.add(matrix[i][YStop]);

            if(XStart != XStop)
                for (int i = YStop - 1; i >= YStart ; i--)
                    list.add(matrix[XStop][i]);

            if(YStart != YStop)
                for (int i = XStop - 1; i >= XStart + 1; i--)
                    list.add(matrix[i][YStart]);

            XStart++; XStop--; YStart++; YStop--;
        }

        return list;
    }
}
