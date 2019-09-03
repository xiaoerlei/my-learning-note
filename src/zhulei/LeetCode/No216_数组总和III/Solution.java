package zhulei.LeetCode.No216_数组总和III;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zl
 * @Date: 2019/8/20 17:35
 * @Description: 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 *              说明：
 *                  所有数字都是正整数。
 *                  解集不能包含重复的组合。 
 *
 *               输入: k = 3, n = 7
 *               输出: [[1,2,4]]
 *
 *               输入: k = 3, n = 9
 *               输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class Solution {

    @Test
    public void function(){
        System.out.println(combinationSum3(3, 7));
    }

    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {

        List<Integer> list = new ArrayList<>();

        backTrace(1, 0, k, n, list);

        return lists;
    }

    private void backTrace(int index, int sum, int count, int target, List<Integer> list) {
        if(sum == target && list.size() == count){
            lists.add(new ArrayList<>(list));
            return;
        }

        if(sum > target || list.size() >= count)
            return;

        for (int i = index; i <= 9 - (count - list.size()) + 1; i++) {
            list.add(i);
            sum += i;
            backTrace(i + 1, sum, count, target, list);
            sum -= i;
            list.remove(list.size() - 1);
        }
    }
}
