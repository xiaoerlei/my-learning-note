package zhulei.LeetCode.No1019_链表中的下一个更大节点;

import org.junit.jupiter.api.Test;
import zhulei.LeetCode.No0_UtilClass.ListNode;

import java.util.*;

/**
 * @Author: zl
 * @Date: 2019/8/16 13:50
 * @Description: 给出一个以头节点 head 作为第一个节点的链表。链表中的节点分别编号为：node_1, node_2, node_3, ... 。
 *
 *              每个节点都可能有下一个更大值（next larger value）：对于 node_i，如果其 next_larger(node_i) 是 node_j.val，
 *              那么就有 j > i 且  node_j.val > node_i.val，而 j 是可能的选项中最小的那个。如果不存在这样的 j，那么下一个更大值为 0 。
 *
 *              返回整数答案数组 answer，其中 answer[i] = next_larger(node_{i+1}) 。
 *
 *              注意：在下面的示例中，诸如 [2,1,5] 这样的输入（不是输出）是链表的序列化表示，其头节点的值为 2，第二个节点值为 1，第三个节点值为 5 。
 *
 *
 *              输入：[2,7,4,3,5]                      输入：[1,7,5,1,9,2,5,1]
 *              输出：[7,0,5,5,0]                      输出：[7,9,9,9,0,5,0,0]
 *
 */
public class Solution {

    @Test
    public void function(){
        int[] arr = {2,7,4,3,5};

    }

    public int[] nextLargerNodes(ListNode head) {
        if(head == null)
            return null;

        List<Integer> list = new ArrayList<>();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }

        int[] res = new int[list.size()];
        // 创建一个栈 stack ，这个栈里面存储的是对应位置的 list 元素及其之后元素中最大的值
        Stack<Integer> stack = new Stack<>();
        // 在 list 中从右往左遍历，stack 中凡是比 list.get(i) 小的都 pop 出去。这样 stack 剩下的元素都是比 list.get(i) 更大的元素
        for (int i = res.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= list.get(i))
                stack.pop();

            res[i] = stack.isEmpty() ? 0 : stack.peek();
            stack.push(list.get(i));
        }

        return res;
    }
}

