package zhulei.JianZhiOffer.No63_数据流中的中位数;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: zl
 * @Date: 2019/6/23 9:35
 * @Description: 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 *          如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *          我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
public class Solution {

    public static void main(String[] args) {
        // 用两个优先队列来完成查找中位数的效果
        // 左边队列为大顶堆，存放数值小的前一半元素
        // 右边队列为小顶堆，对方数值大的后一半元素
        // 保证左右两边的队列元素的个数一致，那么中位数就是两边队列队首元素的平均值
    }

    int count = 0;
    // 大顶堆，存储左半边元素
    PriorityQueue<Integer> left = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    // 小顶堆，存储右半边元素，并且右半边元素都大于左半边
    PriorityQueue<Integer> right = new PriorityQueue<>();

    public void Insert(Integer num) {
        // N 为偶数的情况下插入到右半边。
        // 先将元素插入左半边，然后利用左半边为大顶堆的特点，取出堆顶元素即为最大元素，此时插入右半边
        if(count % 2 == 0){
            left.add(num);
            right.add(left.poll());
        } else {
            right.add(num);
            left.add(right.poll());
        }
        count++;
    }

    public Double GetMedian() {
        if(count % 2 == 0)
            return (left.peek() + right.peek()) / 2.0;
        else
            return (double)right.peek();
    }
}
