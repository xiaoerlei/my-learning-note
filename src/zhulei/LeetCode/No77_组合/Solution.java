package zhulei.LeetCode.No77_组合;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zl
 * @Date: 2019/8/20 14:38
 * @Description: 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 *      输入: n = 4, k = 2
 *      输出:
 *      [
 *          [2,4],
 *          [3,4],
 *          [2,3],
 *          [1,2],
 *          [1,3],
 *          [1,4],
 *      ]
 *
 */
public class Solution {

    @Test
    public void function(){
        System.out.println(combine(4, 2));
    }

    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {

        List<Integer> list = new ArrayList<>();

        backTrace(1, n, k, list);

        return lists;
    }

    private void backTrace(int index, int n, int k, List<Integer> list) {
        if(list.size() == k){
            lists.add(new ArrayList<>(list));
            return;
        }

        // 利用剪枝法来提高运行效率
        /*
            剪枝法思路：
                因为，每次只能选取k个元素放入集合中，所以集合中应该留有 k - list.size() 个空位；
                所以，[i...n]中至少要有 k - list.size() 个元素。

                因为，这里的循环终止条件，到集合中没有空位置为止。即 i <= n - (k - list.size()) + 1，i最多可达到的数值
         */
        for (int i = index; i <= n - (k - list.size()) + 1; i++) {
            list.add(i);
            backTrace(i + 1, n, k, list);
            list.remove(list.size() - 1);
        }
    }
}
