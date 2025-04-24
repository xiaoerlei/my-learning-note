package zhulei.LeetCode.No112_路径总和I;

/**
 * @Author: zl
 * @Date: 2019/4/29 14:08
 * @Description: 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 */
public class PathSum {

    public static void main(String[] args) {

    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        // 最重要的一步
        // 如果到叶子节点，计算的值恰好为0，则返回true
        if (root.left == null && root.right == null) {
            return sum - root.val == 0;
        }
        // 分别对左子树和右子树递归，进行查找
        return hasPathSum(root.left, sum - root.val)
                || hasPathSum(root.right, sum - root.val);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}