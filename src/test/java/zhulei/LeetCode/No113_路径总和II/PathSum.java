package zhulei.LeetCode.No113_路径总和II;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zl
 * @Date: 2019/4/29 14:20
 * @Description: 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 */
public class PathSum {

    public static void main(String[] args) {

    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        // 使用深度优先算法来进行深度递归
        dfs(root, sum, lists, list);
        return lists;
    }

    private void dfs(TreeNode root, int sum, List<List<Integer>> lists, List<Integer> list) {
        if(root == null)
            return;

        list.add(root.val);

        if(root.left == null && root.right == null && sum - root.val == 0)
            // 这里只是一个引用关系，后面还会有对list的增删操作，所以这里需要创建一个新的实例来保存
            lists.add(new ArrayList<>(list));

        dfs(root.left, sum - root.val, lists, list);
        dfs(root.right, sum - root.val, lists, list);

        // 此时底层遍历完后，应当删除这一层遍历中添加的元素（恢复list的原貌），再返回给上层进行其他子树的遍历
        // 因为如果满足条件的话，list是直接被添加到lists中去了。最终返回的是所有满足条件的lists集合
        list.remove(list.size() - 1);
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}