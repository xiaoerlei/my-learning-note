package zhulei.JianzhiOffer.No36_两个链表的第一个公共节点;

import java.util.HashSet;

/**
 * @Author: zl
 * @Date: 2019/6/5 20:31
 * @Description: 输入两个链表，找出它们的第一个公共结点。
 */
public class Solution {

    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        /*
            长度相同有公共结点，第一次就遍历到；没有公共结点，走到尾部NULL相遇，返回NULL
            长度不同有公共结点，第一遍差值就出来了，第二遍一起到公共结点；没有公共，一起到结尾NULL
                因为长短不同的链表，第二遍遍历的时候得到的长度是一定相同的。最后也能走到一起（画个图就出来了）
         */
        while (p1 != p2){
            p1 = (p1 == null ? pHead2 : p1.next);   // p1遍历完后，从p2的头节点开始遍历
            p2 = (p2 == null ? pHead1 : p2.next);   // p2遍历完后，从p1的头节点开始遍历
        }

        return p1;
    }

    // 用set来保存第一条链表中的节点，然后再判断第二条链表中是否存在第一条链表中存在的节点
    public static ListNode otherSolution(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;

        HashSet<ListNode> set = new HashSet<>();
        while (p1 != null) {
            set.add(p1);
            p1 = p1.next;
        }

        while (p2 != null){
            if(set.contains(p2))
                return p2;
            p2 = p2.next;
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