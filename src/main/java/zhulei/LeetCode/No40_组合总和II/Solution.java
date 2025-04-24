package zhulei.LeetCode.No40_组合总和II;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @Author: zl
 * @Date: 2019/8/19 23:51
 * @Description: 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *          candidates 中的每个数字在每个组合中只能使用一次。
 *
 *          输入: candidates = [10,1,2,7,6,1,5], target = 8,
 *          所求解集为:
 *              [
 *                  [1, 7],
 *                  [1, 2, 5],
 *                  [2, 6],
 *                  [1, 1, 6]
 *              ]
 *
 *          输入: candidates = [2,5,2,1,2], target = 5,
 *          所求解集为:
 *              [
 *                  [1,2,2],
 *                  [5]
 *              ]
 */
public class Solution {

    @Test
    public void function(){
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSum2(candidates, target));
    }

    // 用set集合保证有序
    Set<List<Integer>> set = new HashSet<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);    // 对数组进行排序

        backTrace(0, candidates, target, 0, list);
        // 最后再用list来接收set集合，保证返回类型为一个list
        List<List<Integer>> lists = new ArrayList<>(set);
        return lists;
    }

    /*
        思路：
            整体做法和No.39差不多。所以只是在这个基础上来保证解集中不包含重复的元素

            所以，首先需要保证三点：
                第一，递归时需要对递归公式稍作一下改变，即每次递归时，index指针需要往后挪移一位（保证每个元素不会重复使用）；
                第二，输入数组candidates为一个有序数组；
                第三，用set来接收所有的list对象，保证不包含重复元素，
     */
    private void backTrace(int index, int[] candidates, int target, int sum, List<Integer> list) {
        if(sum == target){
            set.add(new ArrayList<>(list));
            return;
        }

        if(sum > target)
            return;

        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            sum += candidates[i];
            backTrace(i + 1, candidates, target, sum, list);
            sum -= candidates[i];
            list.remove(list.size() - 1);
        }

    }
}
