package zhulei.LeetCode.No456_132模式;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * @Author: zl
 * @Date: 2019/9/7 17:28
 * @Description: 给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：当 i < j < k 时，ai < ak < aj。
 *          设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。
 *
 *          注意：n 的值小于15000。
 *
 *          输入: [-1, 3, 2, 0]
 *          输出: True
 *          解释: 序列中有 3 个132模式的的子序列: [-1, 3, 2], [-1, 3, 0] 和 [-1, 2, 0].
 */
public class Solution {

    @Test
    public void function(){
        int[] num = {-1, 3, 2, 0};
        System.out.println(find132pattern(num));
    }

    public boolean find132pattern(int[] nums) {
        // 数组长度小于三是不满足条件的
        if(nums.length < 3)
            return false;

        Stack<Integer> stack = new Stack<>();
        int last = Integer.MIN_VALUE;       // last记录132中的2
        // 必须是从后往前遍历，，这样才能保证nums的前一个元素大于last时，需要被替换
        for (int i = nums.length - 1; i >= 0; i--) {
            // ③ 当 ①② 均满足时，而又nums[i] < last时，就满足条件了
            if (nums[i] < last)
                return true;
            // ① 恰好当前数组数值的元素大于栈顶元素，然后确保存在于 132 中 32 的情况。这里是需要留下一个last来用来最后比较
            while (!stack.isEmpty() && stack.peek() < nums[i])
                last = stack.pop();
            // ② 将当前数组压栈，即 栈中就可以存在两个元素，即 32 的情况
            stack.push(nums[i]);
        }

        return false;
    }
}
