package zhulei.JianzhiOffer.No61_序列化二叉树;

import java.util.*;

/**
 * @Author: zl
 * @Date: 2019/6/20 11:27
 * @Description: 请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class Solution {

    //  ------------------------------ 非递归 ------------------------------
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuilder res = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<TreeNode>() {};
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                queue.add(node.left);
                queue.add(node.right);
                res.append(node.val).append(",");
            } else {
                res.append("null,");
            }
        }
        res.deleteCharAt(res.length() - 1);
        res.append("]");
        return res.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.equals("[]")) {
            return null;
        }
        String[] valArr = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(valArr[0]));
        Queue<TreeNode> queue = new LinkedList<TreeNode>() {};
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!valArr[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(valArr[i]));
                queue.add(node.left);
            }
            i++;
            if (!valArr[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(valArr[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }

    //  ------------------------------ 递归 ------------------------------
    // 序列化时，用“ ”来分开节点，用“#”来表示空节点
    public String Serialize(TreeNode root) {
        if(root == null)
            return "#";
        return root.val + " " + Serialize(root.left) + " " + Serialize(root.right);
    }

    private static String deserializeStr;  // 保存当前的未被序列化的字符串部分
    public TreeNode Deserialize(String str) {
        if(str.length() == 0)
            return null;
        deserializeStr = str;
        return Deserialize();
    }

    public TreeNode Deserialize() {
        // 每次递归前，走抓取最前面的节点（用空格来作为切分），并保存切割后的字符串
        int index = deserializeStr.indexOf(" ");
        String curNode = (index == -1) ? deserializeStr : deserializeStr.substring(0, index);
        deserializeStr = (index == -1) ? "" : deserializeStr.substring(index + 1);
        if(curNode.equals("#"))
            return null;
        // 再通过递归来重构二叉树
        TreeNode root = new TreeNode(Integer.valueOf(curNode));
        root.left = Deserialize();
        root.right = Deserialize();
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}