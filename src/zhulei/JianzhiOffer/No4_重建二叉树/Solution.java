package zhulei.JianzhiOffer.No4_重建二叉树;

import java.util.HashMap;

/**
 * @Author: zl
 * @Date: 2019/5/23 11:16
 * @Description: 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 *          假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *          例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回
 */
public class Solution {

    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        System.out.println(reConstructBinaryTree(pre, in));
    }

    /*
        思路：
            以前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}为例。
            首先根据前序遍历，能得到根节点为 1，所以得到左子树为{4,7,2}， 右子树为{5,3,8,6}，
            然后分别对左右子树进行处理，左子树{4,7,2}中，根节点为 2，所以此时以 2 为根节点的左右子树分别为{4,7}和 {}，
            同理又能得到以4为根节点的左子树为空，右子树为 7，因此所有的左子树都确定完毕

            最终递归左右子树，就能构建唯一完成的二叉树

         注：由前后序遍历获取根节点，再由中序遍历确定左右子树。这也就是为什么必须由前后续遍历的一种，以及中序遍历，能获得唯一的二叉树
     */
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        // inOrderIndex的 key保存的是中序遍历的元素的值，value保存的是中序遍历数组值对应的角标
        HashMap<Integer, Integer> inOrderIndex = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            inOrderIndex.put(in[i], i);
        }
        return reConstructBinaryTree(pre, 0, pre.length - 1, 0, inOrderIndex);
    }

    /**
     *
     * @param pre 前序遍历数组
     * @param preL 前序遍历中，当前子树范围最左边的角标
     * @param preR 前序遍历中，当前子树范围最右边的角标
     * @param inL 中序遍历中，当前子树范围最左边的角标
     * @param inOrderIndex 用来保存中序遍历数组的值以及值对应的数组角标的 map
     * @return 当前子树的根节点作为返回值
     */
    private static TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL, HashMap<Integer, Integer> inOrderIndex) {
        if(preL > preR)
            return null;
        // 每次都取前序遍历的第i个元素作为中序遍历的子树的根节点（第一个元素即为整棵树的根节点）
        TreeNode root = new TreeNode(pre[preL]);
        // 得到中序遍历当前这个子树根节点的脚标索引
        int inRootIndex = inOrderIndex.get(root.val);
        // 得到当前子树所有节点所对应的前序遍历数组的角标范围
        int range = inRootIndex - inL;

        // 分别对左右子树进行递归
        root.left = reConstructBinaryTree(pre, preL + 1, preL + range, inL, inOrderIndex);
        root.right = reConstructBinaryTree(pre, preL + range + 1, preR, inL + range + 1, inOrderIndex);

        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}