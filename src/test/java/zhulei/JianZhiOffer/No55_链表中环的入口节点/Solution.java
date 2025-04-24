package zhulei.JianzhiOffer.No55_链表中环的入口节点;

import java.util.HashMap;

/**
 * @Author: zl
 * @Date: 2019/6/17 11:12
 * @Description: 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if(pHead == null || pHead.next == null)
            return null;
        // 定义快慢指针。如果快指针能追上慢指针，则说明有环
        ListNode p1 = pHead.next;
        ListNode p2 = pHead.next.next;
        // 判断链表是否有环
        while (p1 != p2){
            // 如果有环，则必定不为空
            if(p1.next != null && p2.next.next != null) {
                p1 = p1.next;
                p2 = p2.next.next;
            } else
                return null;
        }
        // 有环之后，再找到环节点
        p2 = pHead;
        while (p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    // 利用HashMap的性质来做
    public ListNode otherSolution(ListNode pHead) {
        if(pHead == null || pHead.next == null)
            return null;

        ListNode cur = pHead;
        HashMap<ListNode, Integer> map = new HashMap<>();
        while (cur != null){
            if(!map.containsKey(cur)) {
                map.put(cur, 1);
                cur = cur.next;
            } else
                return cur;
        }
        return null;
    }
}


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
