package zhulei.JianzhiOffer.No41_和为S的连续正数序列;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zl
 * @Date: 2019/6/10 20:08
 * @Description: 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 *          但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 *          没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 *          现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 *
 *          输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class Solution {

    @Test
    void fun() {
        System.out.println(Arrays.toString(findContinuousSequence(15)));
        System.out.println(FindContinuousSequence(9).toString());
    }


    /**
     * 滑动窗口
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        int left = 1, right = 1, sum = 0;
        List<int[]> seqList = new ArrayList<>();
        while(left <= target / 2) {
            // 不满足条件则滑动左右指针
            while(sum < target) {
                sum += right++;
            }
            while (sum > target) {
                sum -= left++;
            }
            // 满足条件则记录结果
            if(sum == target) {
                int len = right - left;
                int[] seq = new int[len];
                for(int i = 0; i < len; i++) {
                    seq[i] = left + i;
                }
                seqList.add(seq);
                sum -= left++;
            }
        }

        return seqList.toArray(new int[seqList.size()][]);
    }

    /*
        思路：
            利用前后两个指针。
            当和小于sum时，后指针移动，当和大于sum的时候，前指针移动
            利用ArrayList作为工具来操作。后指针移动的时候，添加当前元素到集合中；前指针移动的时候，删除最前面的一个元素（也可以使用队列）
            值得注意的是，当满足和等于sum的时候，也需要维护当前状态。即删除最前面的一个元素。
     */
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        int i = 1;
        int count = 0;  // count来记录当前集合元素的总和
        while (i <= sum){
            if(count < sum){    // 和小于sum则添加元素
                list.add(i);
                count += i;
                i++;
            } else if(count > sum){     // 和大于sum则删除最前面的元素
                count -= list.get(0);
                list.remove(0);
                continue;
            } else {    // 满足条件则把list添加进去。并删除最前的元素来进行维护
                lists.add(new ArrayList<>(list));
                count -= list.get(0);
                list.remove(0);
            }
        }
        return lists;
    }
}
