package zhulei.JianzhiOffer.No64_滑动窗口的最大值;

import org.junit.jupiter.api.Test;
import java.util.*;

/**
 * @Author: zl
 * @Date: 2019/6/23 12:19
 * @Description: 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 *          例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 *          针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 *                  {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class Solution {

    @Test
    void fun() {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(maxSlidingWindow(nums, 3)));
        System.out.println(Arrays.toString(maxInWindows(nums, 3)));
    }

    /**
     * 单调队列
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        // 未形成窗口
        for (int i = 0; i < k; i++) {
            // 队列中保存单调递减的数据，且队头一定是数据最大的值。
            // 如果出现对头元素小于数组当前元素，则删除对头元素，直至队列重新单调递增
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();
        // 形成窗口后
        for (int i = k; i < nums.length; i++) {
            // i-k是已经在区间外了，如果首位等于nums[i-k]，那么说明此时首位值已经不再区间内了，需要删除
            if (deque.peekFirst() == nums[i - k]) {
                deque.removeFirst();
            }
            // 保证队列单调递增
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }


    /**
     * 暴力求解法，优先队列排序，超时
     * @param nums
     * @param size
     * @return
     */
    public int[] maxInWindows(int [] nums, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        // 用LinkedList来作为窗口，以便每次先删除最前面的一个元素，并且添加后面的一个元素，来作为滑动效果
        LinkedList<Integer> queue = new LinkedList<>();
        for (int num : nums) {
            queue.add(num);
            // 当满足窗口的大小时，选取窗口中最大的元素保存在list中
            if (queue.size() == size) {
                // 用优先队列来实现最大顶堆，每次保证队列的最前面都是当前最大的值
                PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
                maxHeap.addAll(queue);
                list.add(maxHeap.peek());
                // 维护窗口，产出最前面的元素
                queue.removeFirst();
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
