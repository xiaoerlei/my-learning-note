package zhulei.DataStructure.Tree.根据前序中序来计算后序遍历;

import org.junit.jupiter.api.Test;
import java.util.*;

public class CalPostOrder {

    @Test
    public void function(){
        // 测试使用
    }


    /**
     * 根据二叉树的前序遍历和中序遍历来构建二叉树（字符串输入）
     * @param pre 前序遍历
     * @param in 中序遍历
     * @return 二叉树的根节点
     */
    public TreeNode reConstructBinaryTreeByString(String pre, String in) {
        // inOrderIndex的 key保存的是中序遍历的元素的值，value保存的是中序遍历数组值对应的角标
        HashMap<String, Integer> inOrderIndex = new HashMap<>();
        for (int i = 0; i < in.length(); i++) {
            inOrderIndex.put(String.valueOf(in.charAt(i)), i);
        }
        return reConstructBinaryTreeByString(pre, 0, pre.length() - 1, 0, inOrderIndex);
    }

    /**
     * 根据二叉树的前序遍历和中序遍历来构建二叉树（整型输入）
     * @param pre 前序遍历
     * @param in 中序遍历
     * @return 二叉树的根节点
     */
    public TreeNode reConstructBinaryTreeByString(int[] pre, int[] in) {
        // inOrderIndex的 key保存的是中序遍历的元素的值，value保存的是中序遍历数组值对应的角标
        HashMap<Integer, Integer> inOrderIndex = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            inOrderIndex.put(pre[i], i);
        }
        return reConstructBinaryTreeByString(pre, 0, pre.length - 1, 0, inOrderIndex);
    }

    // 字符串输入方式
    private TreeNode reConstructBinaryTreeByString(String pre, int preL, int preR, int inL, HashMap<String, Integer> inOrderIndex) {
        if(preL > preR)
            return null;
        // 每次都取前序遍历的第i个元素作为中序遍历的子树的根节点（第一个元素即为整棵树的根节点）
        TreeNode root = new TreeNode(String.valueOf(pre.charAt(preL)));

        // 得到中序遍历当前这个子树根节点的脚标索引
        int inRootIndex = inOrderIndex.get(root.val);
        // 得到当前子树所有节点所对应的前序遍历数组的角标范围
        int range = inRootIndex - inL;

        // 分别对左右子树进行递归
        root.left = reConstructBinaryTreeByString(pre, preL + 1, preL + range, inL, inOrderIndex);
        root.right = reConstructBinaryTreeByString(pre, preL + range + 1, preR, inL + range + 1, inOrderIndex);

        return root;
    }
    // 整型数组输入方式
    private TreeNode reConstructBinaryTreeByString(int[] pre, int preL, int preR, int inL, HashMap<Integer, Integer> inOrderIndex) {
        if(preL > preR)
            return null;
        // 每次都取前序遍历的第i个元素作为中序遍历的子树的根节点（第一个元素即为整棵树的根节点）
        TreeNode root = new TreeNode(pre[preL]);

        // 得到中序遍历当前这个子树根节点的脚标索引
        int inRootIndex = inOrderIndex.get(root.e);
        // 得到当前子树所有节点所对应的前序遍历数组的角标范围
        int range = inRootIndex - inL;

        // 分别对左右子树进行递归
        root.left = reConstructBinaryTreeByString(pre, preL + 1, preL + range, inL, inOrderIndex);
        root.right = reConstructBinaryTreeByString(pre, preL + range + 1, preR, inL + range + 1, inOrderIndex);

        return root;
    }

    // 后续遍历
    private void postOrder(TreeNode node){
        if(node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val);
    }
}


class TreeNode {
    String val;
    int e;
    TreeNode left;
    TreeNode right;
    TreeNode(String x) { val = x; }
    TreeNode(int x) { e = x; }
}
