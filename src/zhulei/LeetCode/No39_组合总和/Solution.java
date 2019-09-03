package zhulei.LeetCode.No39_组合总和;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zl
 * @Date: 2019/8/18 18:54
 * @Description: 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *          candidates 中的数字可以无限制重复被选取。
 *
 *
 *          输入: candidates = [2,3,6,7], target = 7,         输入: candidates = [2,3,5], target = 8,
 *
 *          所求解集为:                                        所求解集为:
 *          [                                                [
 *              [7],                                            [2,2,2,2],
 *              [2,2,3]                                         [2,3,3],
 *          ]                                                   [3,5]
 *                                                           ]
 */
public class Solution {

    @Test
    public void function() {
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));
    }

    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<Integer> list = new ArrayList<>();

        resultSet(0, candidates, target, 0, list);

        return lists;
    }

    /*
        思路：
            这种回溯问题重点是要进行失败处理，即没有满足条件则进行回退。

            所以
                每次递归前都需要把元素添加至集合，并计算总和；
                每次递归完之后，若不满足条件，则需要先还原至之前的总和，以及删除掉之前的元素。

            在递归前后调用下面两个输出，从打印信息中方便找出bug
                System.out.println("before: " + list + "sum = " + sum);
                System.out.println("after: " + list);
     */
    private void resultSet(int index, int[] candidates, int target, int sum, List<Integer> list) {
        // 满足条件情况
        if(sum == target){
            lists.add(new ArrayList<>(list));
            return;
        }

        // 如果和大于目标，则匹配失败
        if(sum > target)
            return;

        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            sum += candidates[i];
            resultSet(i, candidates, target, sum, list);
            // 注意这边一定要还原状态，否则会造成不可逆的情况
            sum -= candidates[i];
            list.remove(list.size() - 1);
        }
    }

}
