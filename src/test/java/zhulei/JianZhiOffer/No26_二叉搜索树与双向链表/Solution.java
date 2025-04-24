package zhulei.JianzhiOffer.No26_二叉搜索树与双向链表;

/**
 * @Author: zl
 * @Date: 2019/5/30 16:52
 * @Description: 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向
 */
public class Solution {

    private TreeNode cur = null;    // 当前节点的引用
    private TreeNode head = null;   // 头节点的引用

    public TreeNode Convert(TreeNode pRootOfTree) {
        inOrder(pRootOfTree);
        return head;
    }

    /*
        思路：
            二分搜索树转化为链表，实际可以看作是中序遍历的结果。可以通过中序遍历来依次找到对应的节点
            然后让临近的节点之间相互引用，形成双向链表。
     */
    private void inOrder(TreeNode node) {
        // 递归结束条件
        if (node == null)
            return;

        inOrder(node.left);

        // 第一个节点作为头节点引用
        if (head == null)
            head = node;
        // 中序遍历中，让临近的两个节点相互引用
        node.left = cur;    // node节点向前指向cur
        if (cur != null)
            cur.right = node;   // cur想后指向node
        // 更新当前节点
        cur = node;

        inOrder(node.right);
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
