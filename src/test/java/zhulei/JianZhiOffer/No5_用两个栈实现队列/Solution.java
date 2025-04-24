package zhulei.JianZhiOffer.No5_用两个栈实现队列;

import java.util.Stack;

/**
 * @Author: zl
 * @Date: 2019/5/23 20:16
 * @Description: 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class Solution {

    public static void main(String[] args) {

    }

    // stack1用来入队
    // stack2用来出队
    static Stack<Integer> stack1 = new Stack<Integer>();
    static Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        // 在stack2为空的情况下，保证stack1全部push到stack2中，然后stack2最上面的一个元素即为stack1最里面的元素
        if(stack2.isEmpty())
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
        // stack2不为空，则继续让stack2出栈，直到stack2中的所有元素都出栈完毕再让stack1入栈到stack2中。这样才能保证先进先出
        return stack2.pop();
    }
}
