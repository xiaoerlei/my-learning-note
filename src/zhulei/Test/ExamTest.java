package zhulei.Test;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class ExamTest {

    @Test
    void fun() {
        int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
        System.out.println(Arrays.toString(spiralOrder(matrix)));
    }

    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0) {
            return new int[0];
        }
        int length = matrix[0].length, height = matrix.length;
        int left = 0, right = length - 1, floor = 0, ceil = height - 1, index = 0;
        int[] res = new int[length * height];
        while(index < res.length) {
            for(int i = left; index < res.length && i <= right; i++) {
                res[index++] = matrix[floor][i];
            }
            floor++;
            for(int i = floor; index < res.length && i <= ceil; i++) {
                res[index++] = matrix[i][right];
            }
            right--;
            for(int i = right; index < res.length && i >= left; i--) {
                res[index++] = matrix[ceil][i];
            }
            ceil--;
            for(int i = ceil; index < res.length && i >= floor; i--) {
                res[index++] = matrix[i][left];
            }
            left++;
        }
        return res;
    }

}
