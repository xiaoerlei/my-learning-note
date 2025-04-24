package zhulei.LeetCode.No437_路径总和III;

/**
 * @Author: zl
 * @Date: 2019/4/29 17:09
 * @Description: 给定一个二叉树，它的每个结点都存放着一个整数值。
 *          找出路径和等于给定数值的路径总数。
 *          路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *          二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 */
public class PathSum {

    public static void main(String[] args) {

    }

    int res = 0;
    public int pathSum(TreeNode root, int sum) {
        if(root == null)
            return 0;
        // 采取双路递归的方式来解决问题
        // incompletePath是以每次pathSum递归得到的节点作为根节点，然后往下继续递归
        incompletePath(root, sum);
        // pathSum的主要用途是为incompletePath提供根节点
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return res;
    }

    // 以当前的节点作为根节点向下递归，找到满足节点相加的和等于sum
    private void incompletePath(TreeNode root, int sum) {
        if(root == null)
            return;

        if(sum - root.val == 0)
            res++;

        incompletePath(root.left, sum - root.val);
        incompletePath(root.right, sum - root.val);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}