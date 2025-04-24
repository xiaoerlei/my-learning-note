package zhulei.JianZhiOffer.No39_平衡二叉树;

/**
 * @Author: zl
 * @Date: 2019/6/8 10:45
 * @Description: 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class Solution {

    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null)
            return true;
        return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1 &&
                IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    private int getHeight(TreeNode node) {
        return node == null ? 0 : 1 + Math.max(getHeight(node.left), getHeight(node.right));
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