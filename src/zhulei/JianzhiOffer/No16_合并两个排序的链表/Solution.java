package zhulei.JianzhiOffer.No16_合并两个排序的链表;

/**
 * @Author: zl
 * @Date: 2019/5/26 17:54
 * @Description: 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Solution {

    public static void main(String[] args) {

    }

    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null && list2 == null)
            return null;

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        // 直到某一个链表为空之时，不断去比较链表的大小，然后让新链表指向值小的节点
        while (list1 != null && list2 != null){
            if(list1.val <= list2.val){
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        // 一旦某一个链表为空了，直接让新链表指向剩下的链表后面的元素
        if(list1 == null)   cur.next = list2;
        if(list2 == null)   cur.next = list1;

        return dummy.next;
    }

}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}