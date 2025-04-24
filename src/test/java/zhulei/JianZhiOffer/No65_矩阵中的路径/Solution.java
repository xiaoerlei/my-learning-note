package zhulei.JianZhiOffer.No65_矩阵中的路径;

/**
 * @Author: zl
 * @Date: 2019/6/23 21:38
 * @Description: 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 *              路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 *              如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 *              例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 *              因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 *
 *              a b c e
 *              s f c s
 *              a d e e
 */
public class Solution {

    public static void main(String[] args) {
        char[] arr = {'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'};
        char[] str = {'b', 'c', 'c', 'e'};
        System.out.println(hasPath(arr, 3, 4, str));
    }

    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        // flag数组用来标记走过的位置
        int[] flag = new int[matrix.length];
        // 分别对矩阵的每一个位置进行上下左右递归查找路径
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if(pathCorrect(matrix, rows, cols, i, j, str, 0, flag))
                    return true;
        return false;
    }

    private static boolean pathCorrect(char[] matrix, int rowsLength, int colsLength, int X, int Y, char[] path, int step, int[] flagArr) {
        // 二维数组相对应的一维数组的索引
        int index = X * colsLength + Y;
        // 不满足条件的情况（越界，对应的值不相等，走过当前路径）
        if(X < 0 || Y < 0 || X >= rowsLength || Y >= colsLength || matrix[index] != path[step] || flagArr[index] == 1)
            return false;
        // 所有路径均对应（递归终止条件）
        if(step == path.length - 1)
            return true;

        flagArr[index] = 1; // 路径标记
        // 对每个方向进行递归比较
        if(pathCorrect(matrix, rowsLength, colsLength, X - 1, Y, path, step + 1, flagArr) ||
            pathCorrect(matrix, rowsLength, colsLength, X, Y - 1, path, step + 1, flagArr) ||
            pathCorrect(matrix, rowsLength, colsLength, X + 1, Y, path, step + 1, flagArr) ||
            pathCorrect(matrix, rowsLength, colsLength, X, Y + 1, path, step + 1, flagArr))
            return true;
        flagArr[index] = 0; // 路径清除

        return false;
    }
}
