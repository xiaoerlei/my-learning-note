package zhulei.JianzhiOffer.No23_二叉搜索树的后续遍历序列;

/**
 * @Author: zl
 * @Date: 2019/5/30 12:56
 * @Description: 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 *              如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
//        int[] arr = {1,3,2,5,7,6,4};
        System.out.println(VerifySquenceOfBST(arr));
    }

    public static boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0 || sequence == null)
            return false;
        return verify(sequence, 0, sequence.length - 1);
    }

    /*
        思路：
            后续遍历的性质是，从左到右，依次遍历最小子树，直至到根节点

            首先找到根节点的值，然后划分左右子树，依次递归。根据左子树的值小于根节点来确定右子树
            如果存在左子树的值大于根节点，或者右子树的值小于根节点，则必定不是后续遍历
     */
    private static boolean verify(int[] sequence, int begin, int end) {
        // 查找结束条件，符合后序遍历条件
        if(end - begin <= 1)
            return true;

        int index = begin;
        // 找到根节点对应的索引
        while (index < end && sequence[index] < sequence[end])
            index++;
        // 如果右子树的值小于根节点的值，则不是后续遍历
        for (int i = index; i < end; i++) {
            if(sequence[i] < sequence[end])
                return false;
        }
        // 分别对左右子树递归
        return verify(sequence, begin, index - 1) && verify(sequence, index, end - 1);
    }
}
