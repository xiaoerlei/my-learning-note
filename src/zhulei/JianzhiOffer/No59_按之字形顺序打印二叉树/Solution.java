package zhulei.JianzhiOffer.No59_按之字形顺序打印二叉树;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: zl
 * @Date: 2019/6/20 10:41
 * @Description: 请实现一个函数按照之字形打印二叉树，
 *          即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class Solution {

    // 就是广度遍历的思想。只不过需要借助Collections.reverse(list)来反转一下顺序
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if(pRoot == null)
            return lists;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        boolean isReverse = false;  // 用一个标志位来判断是否需要反转顺序
        while (!queue.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            int count = queue.size();   // 这里需要额外的记录一下队列的容量，用于记录当前层次的容量
            while (count-- > 0){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            // 反转当前的list
            if(isReverse)
                Collections.reverse(list);
            isReverse = !isReverse;     // 反转完了再反置一下isReverse的值，这样才能保证隔层反转

            lists.add(list);
        }

        return lists;
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}