package zhulei.LeetCode.No120_三角形的最小路径和;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zl
 * @Date: 2019/7/21 14:48
 * @Description: 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *          [
 *              [2],
 *              [3,4],
 *              [6,5,7],
 *              [4,1,8,3]
 *          ]
 *
 *          自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 */

public class Solution {

    @Test
    public void function(){
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(2)));
        list.add(new ArrayList<>(Arrays.asList(3, 4)));
        list.add(new ArrayList<>(Arrays.asList(6, 5, 7)));
        list.add(new ArrayList<>(Arrays.asList(4, 1, 8, 3)));

        System.out.println(minimumTotal(list));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int layer = triangle.size();
        if (layer == 0)
            return 0;

        // 从底向上，用来记录从最下面那一行到每一行的每一个数的最小值
        int[] dp = new int[layer];
        for(int i = 0; i < layer; i++)
            dp[i] = triangle.get(layer - 1).get(i);

        // 从倒数第二层开始，自第向上来计算最小值
        for(int i = layer - 2; i >= 0 ; i--)
            for(int j = 0; j < triangle.get(i).size(); j++)
                // 当前层相邻的最小的值，与上一层的值的和。即为局部最小的值，作为下一层的记录值
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);

        return dp[0];
    }
}
