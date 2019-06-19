package zhulei.JianzhiOffer.No56_删除链表中的重复节点;

/**
 * @Author: zl
 * @Date: 2019/6/17 13:28
 * @Description: 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 *          例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class Solution {

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return pHead;
        // 定义一个指向pHead下一个节点的指针
        ListNode pNext = pHead.next;
        if (pHead.val == pNext.val) {   // 遇到当节点前值等于下一个节点值的情况（即需要删除两个节点的情况）
            while (pNext != null && pHead.val == pNext.val)
                pNext = pNext.next;
            return deleteDuplication(pNext);
        } else {    // 指向下一个节点
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
