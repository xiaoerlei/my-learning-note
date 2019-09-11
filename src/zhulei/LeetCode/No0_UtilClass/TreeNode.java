package zhulei.LeetCode.No0_UtilClass;

/**
 * @Author: zl
 * @Date: 2019/9/10 8:24
 * @Description:
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}
    public TreeNode(int x) { val = x; }

    /**
     * 根据输入的数组，创建数组对应的线性链表
     * @param array 输入数组
     * @param index 根节点索引
     */
    public static TreeNode createBinaryTreeByArray(Integer[] array, int index) {
        TreeNode tn = null;
        if (index < array.length) {
            Integer value = array[index];
            if (value == null) {
                return null;
            }
            tn = new TreeNode(value);
            tn.left = createBinaryTreeByArray(array, 2 * index + 1);
            tn.right = createBinaryTreeByArray(array, 2 * index + 2);
            return tn;
        }
        return tn;
    }
}
