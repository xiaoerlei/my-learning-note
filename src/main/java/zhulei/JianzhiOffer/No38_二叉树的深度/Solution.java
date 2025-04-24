package zhulei.JianzhiOffer.No38_二叉树的深度;

/**
 * @Author: zl
 * @Date: 2019/6/6 16:00
 * @Description: 输入一棵二叉树，求该树的深度。
 *              从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class Solution {

    public int TreeDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
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
