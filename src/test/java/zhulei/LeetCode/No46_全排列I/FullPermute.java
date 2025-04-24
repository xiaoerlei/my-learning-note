package zhulei.LeetCode.No46_全排列I;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zl
 * @Date: 2019/5/5 11:09
 * @Description: 给定一个没有重复数字的序列，返回其所有可能的全排列。
 */
public class FullPermute {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> list = permute(arr);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
    }

    // 通过递归的方式来解决
    /*
        这个问题可以这样来看。
        我们获得了在第一个位置上的所有情况之后，抽去序列T中的第一个位置，
        那么对于剩下的序列可以看成是一个全新的序列T1，序列T1可以认为是与之前的序列毫无关联了。
        同样的，我们可以对这个T1进行与T相同的操作，直到T中只一个元素为止。
        这样我们就获得了所有的可能性。
     */
    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        recursion(nums, 0, list);
        return list;
    }

    // 假设序列为a1,a2,a3...an
    /*
        第一次循环中，a1分别于与2,a3...an交换，交换n-1次后，再交换回来（保证之后再交换的时候，序列的顺序正确）
        第二次循环中，把a1分开成单独的一部分，再让a2分别于与a3...an交换，交换n-2次后，再交换回来
        ...
        第n次循环中，直接输出顺序的序列。
     */
    private static void recursion(int[] nums, int i, List<List<Integer>> lists) {
        // 当指针移到数组的最后一位时，用list来存放序列
        if(i == nums.length - 1){
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                list.add(nums[j]);
            }
            lists.add(list);
        } else {
            for (int j = i; j < nums.length; j++) {
                swap(nums, i, j);
                recursion(nums, i + 1, lists);
                swap(nums, i, j);   // 用于对之前交换过的数据进行还原
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
