package zhulei.JianzhiOffer.No17_树的子结构;

/**
 * @Author: zl
 * @Date: 2019/5/26 17:55
 * @Description: 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class Solution {

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1 == null || root2 == null)
            return false;
        return isSubtree(root1, root2) || isSubtree(root1.left, root2) || isSubtree(root1.right, root2);
    }

    private boolean isSubtree(TreeNode root1, TreeNode root2) {
        // 如果直到子树递归到叶子节点了，说明是子结构关系
        if(root2 == null)
            return true;
        // 如果父树遍递归到了根节点，则说明不存在子结构关系
        if(root1 == null)
            return false;

        if(root1.val != root2.val)
            return false;

        return isSubtree(root1.left, root2.left) && isSubtree(root1.right, root2.right);
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
