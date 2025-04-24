package zhulei.LeetCode.No92_反转链表II;

/**
 * @Author: zl
 * @Date: 2019/6/9 16:02
 * @Description: 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 */
public class ReverseList {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(-1);
        // 让dummyHead指向的下一个节点，作为头节点的引用
        dummyHead.next = head;
        // start一直指向 m 前面的一个节点
        ListNode start = dummyHead;
        for (int i = 1; i < m; i++) {
            start = start.next;
        }
        // head直接指向 m 处
        /*
            即：
                                              m                       n
                    1     ->    1      ->     2     ->    3    ->     4    ->   5
               dummyHead      start         head
         */
        head = start.next;
        // 对 m 到 n 部分的链表进行反转处理
        for (int i = m; i < n; i++) {
            ListNode temp = head.next;
            head.next = temp.next;
            temp.next = start.next;
            start.next = temp;
        }
        return dummyHead.next;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
