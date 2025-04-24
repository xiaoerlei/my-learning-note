package zhulei.LeetCode.No0_UtilClass;

/**
 * @Author: zl
 * @Date: 2019/8/16 15:56
 * @Description: 自己手写的一个工具类，用于leetcode链表类型的题目测试使用
 */
public class ListNode {

    public int val;
    public ListNode next;
    public ListNode head;
    public ListNode temp;

    public ListNode() {}
    public ListNode(int x) { val = x; }


    /**
     * 根据输入的数组，创建数组对应的线性链表
     * @param arr 输入数组
     */
    public void createList(int[] arr){
        if(arr.length > 0)
            head = new ListNode(arr[0]);

        temp = head;
        for (int i = 1; i < arr.length; i++) {
            // 这里每次都需要初始化一个新的节点，然后用临时节点去指向这个新节点
            ListNode node = new ListNode(arr[i]);
            temp.next = node;
            temp = temp.next;
        }
    }

    /**
     * 打印链表
     */
    public void printList(){
        while (head.next != null){
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println(head.val);
    }

    /**
     * 打印指定位置开始的链表
     * @param index 指定开始打印的位置
     */
    public void printList(int index){
        int count = 0;
        while (head.next != null){
            count++;
            if(count >= index)
                System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println(head.val);
    }
}
