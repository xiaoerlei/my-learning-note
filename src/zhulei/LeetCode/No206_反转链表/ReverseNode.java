package zhulei.LeetCode.No206_反转链表;

/**
 * @Author: zl
 * @Date: 2019/3/12 13:02
 * @Description: 反转一个单链表。
 */
public class ReverseNode {

    public static void main(String[] args) {

    }

    // 非递归做法（新开辟一个头节点，然后不断指向之从前一个链表取下的元素）
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode reverseHead = null;   // 建立一个新节点作为头节点
        while (cur != null) {
            /*
               reverseHead      head         temp
                   null           1      ->     2     ->    3    ->     4    ->   5
                                 cur
                   -------------------------------------------------------------
                                head                   temp
                   null    <-     1           2     ->    3    ->     4    ->   5
                             reverseHead     cur
                   -------------------------------------------------------------
                                         ......
             */
            ListNode temp = cur.next;     // 用temp指针来临时保存first节点的指向，避免之后first指针的丢失

            /*
               reverseHead      head        temp
                   null    <-     1           2     ->    3    ->     4    ->   5
                                 cur
                    -------------------------------------------------------------
                                head                   temp
                   null    <-     1     <-    2          3    ->     4    ->   5
                             reverseHead     cur
                    -------------------------------------------------------------
                                        ......
             */
            cur.next = reverseHead;    // 将first的下一个节点指向reverseHead

            /*
                                head        temp
                   null    <-     1           2     ->    3    ->     4    ->   5
                                 cur
                             reverseHead
                   -------------------------------------------------------------
                                head                   temp
                   null    <-     1     <-    2          3    ->     4    ->   5
                                             cur
                                          reverseHead
                   -------------------------------------------------------------
                                        ......
             */
            reverseHead = cur;    // 移动reverseHead，让它指向first指向的节点。即向前移动reverseHead指针

            /*
                                head        temp
                   null    <-     1           2     ->    3    ->     4    ->   5
                             reverseHead     cur
                   -------------------------------------------------------------
                                head                    temp
                   null    <-     1     <-    2           3    ->     4    ->   5
                                         reverseHead     cur
                   -------------------------------------------------------------
                                         ......
             */
            cur = temp;   // 最后再让cur重新指向temp保存的引用。即向前移动first指针
        }
        return reverseHead;
    }

    // 递归做法
    public ListNode recursionSolution(ListNode head) {

        if(head == null || head.next == null)
            return head;
        /**
         *  head    ->   1   ->   2   ->   3   ->   4   ->   5
         *
         *                                    head
         *   1   ->   2   ->   3   ->  4   ->  5   ->   null
         *                                  reverseHead
         *
         *                            head
         *   1   ->   2   ->   3   ->  4   <-   5
         *                                  reverseHead
         *
         *      ...
         */
        ListNode reverseHead = recursionSolution(head.next);
        /**                                       | -----
         *                                     head      |
         *  1   ->   2   ->   3   ->   4   ->   5   ->   null
         *                                   reverseHead
         *
         *                                | -----
         *                             head     |
         *  1   ->   2   ->   3   ->   4   <-   5
         *                                  reverseHead
         *      ...
         */
        head.next.next = head;  // head.next指向head节点(形成一个环)
        /**
         *                                                head
         *  1   ->   2   ->   3   ->   4        null   <-   5
         *                                             reverseHead
         *
         *                                      head
         *  1   ->   2   ->   3                  4     <-   5
         *                                             reverseHead
         *      ...
         */
        head.next = null;   // 断开环

        return reverseHead;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
