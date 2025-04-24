package zhulei.LeetCode.No337_打家劫舍III;

/**
 * @Author: zl
 * @Date: 2019/8/15 22:33
 * @Description:
 */
public class Solution {


    /*
        问题可以转化为：
            包含根节点的最大值，与不包含根节点的最大值的，最大值的比较
     */
    public int rob(TreeNode root) {
        if(root == null)
            return 0;

        int includeRoot = root.val;
        int excludeRoot = rob(root.left) + rob(root.right);

        if(root.left != null) {
            includeRoot += rob(root.left.left);
            includeRoot += rob(root.left.right);
        }

        if(root.right != null) {
            includeRoot += rob(root.right.left);
            includeRoot += rob(root.right.right);
        }

        return Math.max(includeRoot, excludeRoot);
    }
}




class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}