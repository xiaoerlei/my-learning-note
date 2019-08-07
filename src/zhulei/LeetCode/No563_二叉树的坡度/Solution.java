package zhulei.LeetCode.No563_二叉树的坡度;

import org.junit.jupiter.api.Test;

/**
 * @Author: zl
 * @Date: 2019/8/6 14:46
 * @Description: 给定一个二叉树，计算整个树的坡度。
 *          一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。
 *          整个树的坡度就是其所有节点的坡度之和。
 *
 *          输入:
 *                  1
 *                /   \
 *               2     3
 *          输出: 1
 *
 *                  解释:
 *                      结点的坡度 2 : 0
 *                      结点的坡度 3 : 0
 *                      结点的坡度 1 : |2 - 3| = 1
 *                      树的坡度 : 0 + 0 + 1 = 1
 *
 */
public class Solution {

    @Test
    public void function(){

    }

    public int findTilt(TreeNode root) {
        if(root == null)
            return 0;

        return Math.abs(gradeCount(root.left) - gradeCount(root.right)) + findTilt(root.left) + findTilt(root.right);
    }

    private int gradeCount(TreeNode root) {
        if(root == null)
            return 0;

        return gradeCount(root.left) + gradeCount(root.right) + root.val;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
