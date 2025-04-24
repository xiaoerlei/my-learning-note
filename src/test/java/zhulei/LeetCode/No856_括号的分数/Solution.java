package zhulei.LeetCode.No856_括号的分数;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * @Author: zl
 * @Date: 2019/9/6 13:56
 * @Description: 给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
 *          () 得 1 分。
 *          AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
 *          (A) 得 2 * A 分，其中 A 是平衡括号字符串。
 *
 *          输入： "()"                    输入： "(()(()))"
 *          输出： 1                       输出： 6
 */
public class Solution {

    @Test
    public void function(){
        System.out.println(scoreOfParentheses("(()(()))"));
    }

    /*
        思路：
            每次碰到'('，则将0压栈，相反则先出栈，然后替换为1，并进行翻倍
            但提前必须要先push一个0

            字符串 (()(())) 每次对应的栈的情况：
                [0, 0]          (
                [0, 0, 0]       ((
                [0, 1]          (()
                [0, 1, 0]       (()(
                [0, 1, 0, 0]    (()((
                [0, 1, 1]       (()(()
                [0, 3]          (()(())
                [6]             (()(()))
     */
    public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '('){
                stack.push(0);
            }
            else {
                int A = stack.pop();
                int B = stack.pop();
                stack.push(B + Math.max(2 * A, 1));
            }
        }
        return stack.peek();
    }
}
