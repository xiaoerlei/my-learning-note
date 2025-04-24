package zhulei.JianZhiOffer.No15_反转链表;

/**
 * @Author: zl
 * @Date: 2019/5/26 17:16
 * @Description: 输入一个链表，反转链表后，输出新链表的表头。
 */
public class Solution {

    public static void main(String[] args) {

    }

    public ListNode ReverseList(ListNode head) {
        ListNode first = new ListNode(-1);
        while (head != null){
            ListNode second = head.next;
            head.next = first.next;
            first.next = head;
            head = second;
        }
        return first.next;
    }

    public ListNode lastNode(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode dummy = lastNode(head.next);
        head.next.next = head;
        head.next = null;

        return dummy;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}