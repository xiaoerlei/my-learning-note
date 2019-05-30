package zhulei.JianzhiOffer.No22_从上往下打印二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: zl
 * @Date: 2019/5/30 10:33
 * @Description: 从上往下打印出二叉树的每个节点，同层节点从左至右打印。（广度优先遍历）
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode treeNode = null;
        System.out.println(PrintFromTopToBottom(treeNode).toString());
    }

    /*
        思路：
            定义两个集合。
                一个ArrayList，用于存取广度遍历的节点的值；
                一个Queue，用于保存当前子节点，以便之后出队保存于ArrayList中
            每次把当前的根节点入队。左节点在前，右节点在后，直到最后所有的节点遍历完毕之前，把当前节点按顺序入队
     */
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();

        // root为空要返回list，一个空的集合
        if(root == null)
            return list;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            // 首先让根节点入队
            TreeNode t = queue.poll();
            list.add(t.val);
            if(t.left != null)
                queue.add(t.left);
            if(t.right != null)
                queue.add(t.right);
        }

        return list;
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