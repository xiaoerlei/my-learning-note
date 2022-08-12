package zhulei.JianzhiOffer.No70_队列的最大值;

import org.junit.jupiter.api.Test;
import java.util.*;

/**
 * @Author: zl
 * @Date: 2022/8/11 18:49
 * @Description:
 *      请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 *      若队列为空，pop_front 和 max_value 需要返回 -1
 */
public class Solution {

    /**
     * 维护一个正常队列 realQueue，用于正常的入队和出队操作
     * 维护一个单调递增队列 increasingQueue，用户在O(1)复杂度内，直接在队头获取最大值
     */
    static Queue<Integer> realQueue;
    static Deque<Integer> increasingQueue;

    public Solution() {
        realQueue = new LinkedList<>();
        increasingQueue = new LinkedList<>();
    }

    @Test
    void fun() {

    }

    /**
     * 队列最大值
     * @return
     */
    public int max_value() {
        if (increasingQueue.isEmpty()) {
            return -1;
        }
        return increasingQueue.peekFirst();
    }

    /**
     * 在队列中添加元素
     * @param value
     */
    public void push_back(int value) {
        while (!increasingQueue.isEmpty() && increasingQueue.peekLast() < value) {
            increasingQueue.pollLast();
        }
        increasingQueue.offerLast(value);
        realQueue.offer(value);
    }

    /**
     * 删除元素
     * @return
     */
    public int pop_front() {
        if (realQueue.isEmpty()) {
            return -1;
        }
        int res = realQueue.poll();
        // increasingQueue只是辅助队列，如果俩队列队头不是同一元素，就不用删除
        if (res == increasingQueue.peekFirst()) {
            increasingQueue.pollFirst();
        }
        return res;
    }
}
