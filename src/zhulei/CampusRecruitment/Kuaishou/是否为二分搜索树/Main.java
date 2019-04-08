package zhulei.CampusRecruitment.Kuaishou.是否为二分搜索树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Author: zl
 * @Date: 2019/3/31 15:09
 * @Description: 给定一个满二叉树，如果是二分搜索树则返回true，否则返回false
 */
public class Main {

    private static ArrayList<Integer> list;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        list = new ArrayList<>();
        if(input.contains("None")){
            System.out.println("False");
            return;
        }
        String[] arrIn = input.split(",");
        int[] treeNum = new int[arrIn.length];
        for (int i = 0; i < treeNum.length; i++)
            treeNum[i] = Integer.parseInt(arrIn[i]);
        // 创建树
        TreeNode root = createBinaryTree(treeNum);
        // 中序存储数据
        inOrderTraverse(root);
        // 判断是否为二分查找树
        for (int i = 1; i < list.size(); i++) {
            if(list.get(i) < list.get(i - 1)) {
                System.out.println("False");
                return;
            }
        }
        System.out.println("True");
        sc.close();
    }

    // 中序遍历的方式存储数据(中序遍历对应的是按数据大小顺序存储的)
    private static void inOrderTraverse(TreeNode node) {
        if (node == null)
            return;
        inOrderTraverse(node.left);
        list.add(node.val);
        inOrderTraverse(node.right);
    }

    // 创建二叉树
    private static TreeNode createBinaryTree(int[] treeNum) {
        LinkedList<TreeNode> node = new LinkedList<>();
        // 首先将每一个值存储在节点中，初始化节点
        for (int i = 0; i < treeNum.length; i++)
            node.add(new TreeNode(treeNum[i]));
        // 为二叉树建立引用关系
        for (int i = 0; i < node.size() / 2 - 1; i++) {
            node.get(i).left = node.get(i * 2 + 1);
            node.get(i).right = node.get(i * 2 + 2);
        }
        // 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理
        int lastParentIndex = treeNum.length / 2 - 1;
        // 左孩子
        node.get(lastParentIndex).left = node.get(lastParentIndex * 2 + 1);
        // 右孩子,如果数组的长度为奇数才建立右孩子
        if (treeNum.length % 2 == 1)
            node.get(lastParentIndex).right = node.get(lastParentIndex * 2 + 2);

        return node.get(0);
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}