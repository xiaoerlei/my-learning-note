package zhulei.JianzhiOffer.No60_把二叉树打印成多行;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: zl
 * @Date: 2019/6/20 11:23
 * @Description: 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class Solution {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if(pRoot == null)
            return lists;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        while (!queue.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            // 这里需要额外的记录一下队列的容量，用于记录当前层次的容量
            int count = queue.size();
            while (count-- > 0){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }

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
