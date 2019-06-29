package zhulei.Arithmetic.BackTracking.N皇后问题;

/**
 * @Author: zl
 * @Date: 2019/6/25 12:34
 * @Description: 将八位皇后放在一张8x8的棋盘上，使得每位皇后都无法吃掉别的皇后，（即任意两个皇后都不在同一条横线，竖线和斜线上）
 *          问一共有多少种摆法。（此问题是在1848年由棋手马克思·贝瑟尔提出的）
 */
public class EightQueens {

    public static int[][] arr = new int[8][8];  //棋盘，放皇后
    public static int count = 0;    //存储方案结果数量

    public static void main(String[] args) {
        System.out.println("八皇后问题");
        findQueen(0);
        System.out.println("八皇后问题共有：" + count + "种可能");
    }

    /*
        思路：
            第一次进来，row=0，意思是要在第一行摆皇后，只要传进来的row参数不是8，表明还没出结果，就都不会走if里面的return。
            那么就进入到for循环里面，column从0开始，即第一列。此时第一行第一列肯定合乎要求（即check方法肯定通过），能放下皇后，因为还没有任何其他皇后来干扰。

            关键是check方法通过了之后，在if里面又会调用一下自己（即递归），row加了1，表示摆第二行的皇后了。
            第二行的皇后在走for循环的时候，分两种情况，
                第一种情况：for循环没走到头时就有通过check方法的了，那么这样就顺理成章地往下走再调用一下自己（即再往下递归），row再加1（即摆第三行的皇后了，以此类推）。
                第二种情况：for循环走到头了都没有通过check方法的，说明第二行根本一个皇后都摆不了，也触发不了递归，下面的第三行等等后面的就更不用提了，
                    此时控制第一行皇后位置的for循环column加1，即第一行的皇后往后移一格，即摆在第一行第二列的位置上，然后再往下走，重复上述逻辑。

            注意：一定要添加清零的代码，它只有在皇后摆不下去的时候会执行清0的动作（避免脏数据干扰），
                 如果皇后摆放很顺利的话从头到尾是不会走这个请0的动作的，因为已经提前走if里面的return方法结束了。
     */
    private static void findQueen(int index) {
        if(index > 7){
            count++;
            print();    // 打印每一种情况
        }

        for (int i = 0; i < 8; i++) {
            if(check(index, i)){
                arr[index][i] = 1;
                findQueen(index + 1);
                arr[index][i] = 0;  // 判断失败，则进行回溯
            }
        }
    }

    // 判断当前位置的皇后是否符合条件
    private static boolean check(int x, int y) {
        // 检查行列冲突
        for (int i = 0; i < 8; i++) {
            if(arr[i][y] == 1)
                return false;
        }
        // 检查主对角线冲突（只用检查x行以上的部分，又因为是主对角线，所以每次都需要y左移一位）
        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
            if(arr[i][j] == 1)
                return false;
        }
        // 检查辅对角线冲突（只用检查x行以上的部分，又因为是辅对角线，所以每次都需要y又移一位）
        for (int i = x - 1, j = y + 1; i >= 0 && j < 8; i--, j++) {
            if(arr[i][j] == 1)
                return false;
        }
        return true;
    }

    // 打印输出结果
    public static void print(){
        System.out.println("方案" + count + ":");
        for(int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++)
                if (arr[i][j] == 1)
                    System.out.print("O  ");
                else
                    System.out.print("+  ");
            System.out.println();
        }
        System.out.println();
    }
}
