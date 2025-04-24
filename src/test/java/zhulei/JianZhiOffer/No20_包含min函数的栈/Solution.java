package zhulei.JianZhiOffer.No20_包含min函数的栈;

import java.util.Stack;

/**
 * @Author: zl
 * @Date: 2019/5/29 20:46
 * @Description: 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class Solution {

    // 一般栈
    private Stack<Integer> dataStack = new Stack<>();
    // 用来实现min方法的栈
    private Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        dataStack.push(node);
        // 如果当前栈为空，则当前node为最小值。否则压入node值与当前栈顶值中较小的值
        // minStack中只保存最小的值
        minStack.push(minStack.isEmpty() ? node : Math.min(minStack.peek(), node));
    }

    public void pop() {
        dataStack.pop();
        // 因为peek是查看栈顶的元素，所以每次pop出栈的时候，最小值栈也需要pop出栈顶的元素
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
