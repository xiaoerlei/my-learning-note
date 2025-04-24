package zhulei.JianZhiOffer.No24_二叉树中和为某一值的路径;

import java.util.ArrayList;

/**
 * @Author: zl
 * @Date: 2019/5/30 16:06
 * @Description: 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 *              路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 *              (注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class Solution {

    public static void main(String[] args) {

    }

    // 同leetcode113 路径总和
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();

        dfs(root, target, list, lists);

        return lists;
    }

    private void dfs(TreeNode root, int target, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> lists) {
        if(root == null)
            return;

        list.add(root.val);

        if(root.left == null && root.right == null && target == root.val)
            lists.add(new ArrayList<>(list));

        dfs(root.left, target - root.val, list, lists);
        dfs(root.right, target - root.val, list, lists);

        list.remove(list.size() - 1);
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
