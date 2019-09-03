package zhulei.LeetCode.No455_分发饼干;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: zl
 * @Date: 2019/8/22 13:33
 * @Description: 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。
 *          但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；
 *          并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。
 *          你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 *
 *
 *          输入: [1,2], [1,2,3]
 *          输出: 2
 *
 *          解释:
 *              你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
 *              你拥有的饼干数量和尺寸都足以让所有孩子满足。
 *              所以你应该输出2.
 *
 */
public class Solution {

    @Test
    public void function(){
        int[] g = {1,2};
        int[] s = {1,2,3};
        System.out.println(findContentChildren(g, s));
    }

    /*
        思路：贪心算法
            首先，把孩子数组和饼干数组都按从大到小的顺序排好序
            然后，每次拿最大的饼干去满足最贪心的孩子。
                如果满足不了，则说明这个孩子始终是不开心的；
                如果满足了，都分别消耗掉这个孩子和饼干，指针分别往后移动一位
            所以，全部这样比较完毕之后才能确定到底最多能让多少孩子开心
     */
    public int findContentChildren(int[] g, int[] s) {
        int res = 0;
        // 这边只有首先把基本类型的数组转化为包装类类型数组才能用Arrays工具类来从大到小排序
        Integer[] child = new Integer[g.length];
        for (int i = 0; i < g.length; i++) {
            child[i] = g[i];
        }
        Arrays.sort(child, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        Integer[] cookies = new Integer[s.length];
        for (int i = 0; i < s.length; i++) {
            cookies[i] = s[i];
        }
        Arrays.sort(cookies, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        int childIndex = 0, cookiesIndex = 0;
        while (childIndex < child.length && cookiesIndex < cookies.length){
            if(cookies[cookiesIndex] >= child[childIndex]){
                res++;
                childIndex++;
                cookiesIndex++;
            }
            else
                childIndex++;
        }

        return res;
    }
}
