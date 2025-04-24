package zhulei.JianZhiOffer.No21_弹出序列;

import java.util.LinkedHashMap;

/**
 * @Author: zl
 * @Date: 2019/5/30 9:39
 * @Description: 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 *              例如序列1,2,3,4,5是某栈的压入顺序，
 *                  序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 *                  但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 *              （注意：这两个序列的长度是相等的）
 */
public class Solution {

    public static void main(String[] args) {
        int[] push = {1,2,3,4,5};
//        int[] pop = {4,5,3,2,1};
        int[] pop = {4,5,3,1,2};

        System.out.println(IsPopOrder(push, pop));
    }

    /*
        思路：
            首先归纳正确入栈出栈的方式：以入栈的次序作为从小到大的索引。则比当前元素入栈的次序早的元素，都必须要逆序出栈
            所以，定义一个LinkedHashMap，保证顺序存储。以元素作为key，以便找到对应出栈元素的索引（入栈次序），然后入栈次序作为value
            如果存在较大出栈次序的元素已经提前出栈，但较小次序的元素又是以按入栈的顺序出栈的情况，则说明不是正确的出栈顺序
            最后，还需要保证入栈和出栈两组元素是一一对应的。
     */
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        // LinkedHashMap保证顺序存储
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < pushA.length; i++) {
            map.put(pushA[i], i);
        }

        int index = Integer.MIN_VALUE;
        for (int i = 0; i < popA.length; i++) {
            if(map.get(popA[i]) == null)    // 如果找不到对应的元素，则说明不是正确的出栈顺序
                return false;
            // 保留最大的出栈次序的索引
            index = Math.max(index, map.get(popA[i]));
            // 如果存在较大出栈次序的元素已经提前出栈，但较小次序的元素又是以按入栈的顺序出栈的情况，则说明不是正确的出栈顺序
            if(i > 0 && map.get(popA[i]) < index && map.get(popA[i - 1]) < map.get(popA[i]))
                return false;
        }
        return true;
    }
}
