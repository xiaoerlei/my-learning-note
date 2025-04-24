package zhulei.JianzhiOffer.No54_字符流中第一个不重复的字符;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: zl
 * @Date: 2019/6/16 23:30
 * @Description: 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 *          例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 *          当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 */
public class Solution {

    public static void main(String[] args) {

    }

    Queue<Character> queue = new LinkedList<>();
    char[] ascll = new char[128];
    //Insert one char from stringstream
    public void Insert(char ch) {
        queue.add(ch);
        ascll[ch]++;
        // 如果ascll数组中出现重复元素（> 1），则出队，此时队首元素为非重复元素。
        // 如果队列中只有两个元素，且重复。因为ascll[i] > 1，所以两个元素均会出队
        while (!queue.isEmpty() && ascll[queue.peek()] > 1)
            queue.poll();
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        // 队首元素即为第一个非重复元素
        return queue.isEmpty() ? '#' : queue.peek();
    }
}
