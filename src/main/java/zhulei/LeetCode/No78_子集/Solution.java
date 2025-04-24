package zhulei.LeetCode.No78_子集;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @Author: zl
 * @Date: 2019/8/20 17:12
 * @Description: 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *          说明：解集不能包含重复的子集。
 *
 *          输入: nums = [1,2,3]
 *          输出:
 *              [
 *                  [3],
 *                  [1],
 *                  [2],
 *                  [1,2,3],
 *                  [1,3],
 *                  [2,3],
 *                  [1,2],
 *                  []
 *              ]
 *
 */
public class Solution {

    @Test
    public void function(){
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }

    // 这里不需要通过排序来防止集合元素重复，因为数组本身时不包含重复元素的
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();

        backTrace(0, nums, list);

        return lists;
    }

    // 回溯调用
    private void backTrace(int index, int[] nums, List<Integer> list) {
        lists.add(new ArrayList<>(list));

        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            backTrace(i + 1, nums, list);
            list.remove(list.size() - 1);
        }
    }
}
