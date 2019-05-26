package zhulei.JianzhiOffer.No14_链表中的第k个节点;

/**
 * @Author: zl
 * @Date: 2019/5/26 16:58
 * @Description: 输入一个链表，输出该链表中倒数第k个结点。
 */
public class Solution {

    public static void main(String[] args) {

    }

    /*
        思路：
            分别用两个指针来指向链表
            指针p1指向长度为k的链表节点处，指针p2指向链表的头节点
            然后直到p1指向链表结尾，p2为链表中倒数第k个结点
     */
    public ListNode FindKthToTail(ListNode head, int k) {
        if(head == null)
            return null;
        // 让指针p1指向长度为k的链表节点处
        ListNode p1 = head;
        while (p1 != null && k-- > 0)
            p1 = p1.next;
        // 如果到了链表末尾，k还大于0，则返回空
        if(k > 0)
            return null;
        // 让指针p2指向链表的头节点
        ListNode p2 = head;
        while (p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}