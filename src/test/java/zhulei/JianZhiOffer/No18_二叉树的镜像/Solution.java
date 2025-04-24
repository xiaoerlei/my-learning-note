package zhulei.JianZhiOffer.No18_二叉树的镜像;

/**
 * @Author: zl
 * @Date: 2019/5/29 19:16
 * @Description: 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class Solution {

    public void Mirror(TreeNode root) {
        if(root == null)
            return;
        swap(root);
        Mirror(root.left);
        Mirror(root.right);
    }

    private void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
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