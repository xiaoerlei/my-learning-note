package zhulei.LeetCode.No47_全排列II;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zl
 * @Date: 2019/5/5 16:06
 * @Description: 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 */
public class FullPermute {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2};
        List<List<Integer>> list = permute(arr);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
    }

    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        recursion(nums, 0, list);
        return list;
    }

    private static void recursion(int[] nums, int i, List<List<Integer>> lists) {
        if(i == nums.length - 1){
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                list.add(nums[j]);
            }
            lists.add(list);
        } else {
            for (int j = i; j < nums.length; j++) {
                if(swapAccept(nums, i, j))  // 检查判断，如果重复的话就跳过此次循环，进行下次递归
                    continue;
                swap(nums, i, j);
                recursion(nums, i + 1, lists);
                swap(nums, i, j);   // 用于对之前交换过的数据进行还原
            }
        }
    }
    // 每一次交换递归之前对元素进行检查，如果这个元素在后面还存在数值相同的元素，那么我们就可以跳过进行下一次循环递归
    private static boolean swapAccept(int[] nums, int i, int j) {
        for (int k = i; k < j; k++) {
            if(nums[k] == nums[j])
                return true;
        }
        return false;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
