package zhulei.LeetCode.No435_无重叠区间;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @Author: zl
 * @Date: 2019/8/22 14:34
 * @Description: 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 *
 *      注意:
 *          可以认为区间的终点总是大于它的起点。
 *          区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 *
 *
 *      输入: [ [1,2], [2,3], [3,4], [1,3] ]
 *      输出: 1
 *      解释: 移除 [1,3] 后，剩下的区间没有重叠。
 *
 */
public class Solution {

    @Test
    public void function(){
        int[][] arr = {{1,2}, {2,3}, {3,4}, {1,3}};
        System.out.println(eraseOverlapInterval(arr));
        System.out.println(eraseOverlapIntervals(arr));
    }

    /*
        贪心算法做法
     */
    public int eraseOverlapInterval(int[][] intervals) {
        // 首先按照上升子序列的方式来进行排序
        List<Intervals> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            list.add(new Intervals(intervals[i][0], intervals[i][1]));
        }
        Collections.sort(list, new Comparator<Intervals>() {
            @Override
            public int compare(Intervals o1, Intervals o2) {
                if(o1.end != o2.end)
                    return o1.end - o2.end;
                return o1.start - o2.start;
            }
        });
        // 数组为空判断
        if(list.size() == 0)
            return 0;

        int res = 1, pre = 0;
        for (int i = 1; i < list.size(); i++) {
            if(list.get(i).start >= list.get(pre).end){
                res++;
                pre = i;
            }
        }

        return list.size() - res;
    }


    /*
        动态规划（最长向上子序列做法）
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        // 首先按照上升子序列的方式来进行排序
        List<Intervals> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            list.add(new Intervals(intervals[i][0], intervals[i][1]));
        }
        Collections.sort(list, new Comparator<Intervals>() {
            @Override
            public int compare(Intervals o1, Intervals o2) {
                if(o1.start != o2.start)
                    return o1.start - o2.start;
                return o1.end - o2.end;
            }
        });

        int[] dp = new int[list.size()];
        Arrays.fill(dp, 1);

        for (int i = 1; i < list.size(); i++) {
            for (int j = 0; j < i; j++) {
                if(list.get(i).start >= list.get(j).end)
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
            }
        }

        int res = 0;
        for (int i = 0; i < dp.length; i++)
            res = Math.max(res, dp[i]);

        return list.size() - res;
    }

}

// 自定义一个节点类
class Intervals{
    int start;
    int end;

    public Intervals(){ }
    public Intervals(int l, int r){
        start = l;
        end = r;
    }
}