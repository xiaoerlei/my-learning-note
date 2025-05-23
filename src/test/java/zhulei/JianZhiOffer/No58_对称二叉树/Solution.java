package zhulei.JianZhiOffer.No58_对称二叉树;

/**
 * @Author: zl
 * @Date: 2019/6/19 10:59
 * @Description: 请实现一个函数，用来判断一颗二叉树是不是对称的。
 *          注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class Solution {

    boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot == null)
            return true;
        return isSymmetrical(pRoot.left, pRoot.right);
    }

    private boolean isSymmetrical(TreeNode left, TreeNode right) {
        if(left == null && right == null)
            return true;

        if(left == null || right == null)
            return false;

        if(left.val != right.val)
            return false;
        // 注意这个地方，镜像对称一定要左子树的左孩子和右子树的右孩子对应，左子树的右孩子和右子树的左孩子对应
        return isSymmetrical(left.left, right.right) && isSymmetrical(left.right, right.left);
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