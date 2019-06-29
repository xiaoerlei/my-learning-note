package zhulei.JianzhiOffer.No61_序列化二叉树;

/**
 * @Author: zl
 * @Date: 2019/6/20 11:27
 * @Description: 请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class Solution {

    public static void main(String[] args) {

    }

    // 序列化时，用“ ”来分开节点，用“#”来表示空节点
    String Serialize(TreeNode root) {
        if(root == null)
            return "#";
        return root.val + " " + Serialize(root.left) + " " + Serialize(root.right);
    }

    String deserializeStr;  // 保存当前的未被序列化的字符串部分
    TreeNode Deserialize(String str) {
        if(str.length() == 0)
            return null;
        deserializeStr = str;
        return Deserialize();
    }

    TreeNode Deserialize() {
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
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}