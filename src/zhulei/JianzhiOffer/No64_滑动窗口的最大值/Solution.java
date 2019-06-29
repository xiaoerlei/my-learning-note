package zhulei.JianzhiOffer.No64_滑动窗口的最大值;

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

    public static void main(String[] args) {
        int[] num = {2,3,4,2,6,2,5,1};
        int size = 1;
        System.out.println(maxInWindows(num, size).toString());
    }

    public static ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        // 用LinkedList来作为窗口，以便每次先删除最前面的一个元素，并且添加后面的一个元素，来作为滑动效果
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            queue.add(num[i]);
            // 当满足窗口的大小时，选取窗口中最大的元素保存在list中
            if(queue.size() == size){
                // 用优先队列来实现最大顶堆，每次保证队列的最前面都是当前最大的值
                PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2 - o1;
                    }
                });
                maxHeap.addAll(queue);
                list.add(maxHeap.peek());
                // 维护窗口，产出最前面的元素
                ((LinkedList<Integer>) queue).removeFirst();
            }
        }
        return list;
    }
}
