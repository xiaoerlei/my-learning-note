package zhulei.JianzhiOffer.No1_二维数组中的查找;

/**
 * @Author: zl
 * @Date: 2019/5/23 10:30
 * @Description: 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 *              请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Solution {

    public static void main(String[] args) {
        int target = 7;
//        int[][] array = {{1,2,8,9}, {2,4,9,12}, {4,7,10,13}, {6,8,11,15}};
        int[][] array = {{}};
        System.out.println(Find(target, array));
    }

    public static boolean Find(int target, int [][] array) {
        int m = array.length;
        int n = array[0].length;
        // 判断数组为空的情况
        if(n == 0)
            return false;
        for (int i = 0; i < m; i++) {
            // 如果二维数组的某一行的第一个元素大于目标元素，则表示整个二维数组都不存在这个目标元素
            if(target < array[i][0])
                return false;
            // 从左右两边双向查找元素，通过比较差值来加快查询效率
            for (int j = 0, k = n - 1; j < k; ) {
                if(target > array[i][k] || target < array[i][j])
                    break;
                int left = Math.abs(target - array[i][j]);
                int right = Math.abs(target - array[i][k]);
                // 找到了直接退出
                if(left == 0 || right == 0)
                    return true;
                // 哪边差值小，就挪动哪边的指针
                if(left - right > 0)
                    k--;
                else
                    j++;
            }
        }

        return false;
    }

}
