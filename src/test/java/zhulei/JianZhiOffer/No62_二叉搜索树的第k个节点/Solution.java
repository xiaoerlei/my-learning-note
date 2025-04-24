package zhulei.JianZhiOffer.No62_二叉搜索树的第k个节点;

/**
 * @Author: zl
 * @Date: 2019/6/23 9:25
 * @Description: 给定一棵二叉搜索树，请找出其中的第k小的结点。
 *              例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 */
public class Solution {

    public static void main(String[] args) {

    }

    int index = 0;
    TreeNode node;
    TreeNode KthNode(TreeNode pRoot, int k) {
        inOrder(pRoot, k);
        return node;
    }

    // 中序遍历查找
    private void inOrder(TreeNode pRoot, int k) {
        if(pRoot == null || index >= k)
            return;
        inOrder(pRoot.left, k);
        index++;
        if(index == k)
            node = pRoot;
        inOrder(pRoot.right, k);
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