package zhulei.LeetCode.No236_二叉树的最近公共祖先;

import org.junit.jupiter.api.Test;
import zhulei.LeetCode.No0_UtilClass.TreeNode;

/**
 * @Author: zl
 * @Date: 2019/9/10 8:37
 * @Description: 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 *               输出: 3
 *               解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 *
 */
public class Solution {

    @Test
    public void function(){
        Integer[] arr = {3,5,1,6,2,0,8,null,null,7,4};
        TreeNode root = TreeNode.createBinaryTreeByArray(arr, 0);
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);
        System.out.println(lowestCommonAncestor(root, p, q).val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;

        if (root.val == p.val || root.val == q.val)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null)
            return root;
        else if (left != null)
            return left;
        else if (right != null)
            return right;

        return null;
    }
}
