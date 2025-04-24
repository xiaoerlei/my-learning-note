package zhulei.LeetCode.No394_字符串解码;

import org.junit.jupiter.api.Test;
import java.util.Stack;

/**
 * @Author: zl
 * @Date: 2019/9/7 14:38
 * @Description: 给定一个经过编码的字符串，返回它解码后的字符串。
 *          编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *          你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *          此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 *          s = "3[a]2[bc]",            返回 "aaabcbc".
 *          s = "3[a2[c]]",             返回 "accaccacc".
 *          s = "2[abc]3[cd]ef",        返回 "abcabccdcdcdef".
 *
 */
public class Solution {

    @Test
    public void function() {
        System.out.println(decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }

    public String decodeString(String s) {
        String res = "";
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            // 逆向思想，匹配右括号，这样可以有效的拿到最小的括号部分
            if (s.charAt(i) == ']') {
                // StringBuilder来接收最小括号部分的字符串
                String part = "";
                while (!stack.peek().equals("[")){
                    // 这里需要逆序，保证出栈后拼接的顺序依然是顺序
                    part = stack.pop() + part;
                }
                // 最后再把左括号出栈
                stack.pop();

                // 再获取括号前面的数字
                StringBuilder num = new StringBuilder();
                // 防止出现大于9的数字，所以也需要循环判断
                while (!stack.isEmpty() && stack.peek().charAt(0) >= '0' && stack.peek().charAt(0) <= '9'){
                    num.append(stack.pop());
                }
                int count = Integer.parseInt(num.reverse().toString());
                StringBuilder aim = new StringBuilder();
                for (int j = 0; j < count; j++) {
                    aim.append(part);
                }
                // 将最后处理过的结果进行压栈
                stack.push(aim.toString());
            }
            else {
                stack.push(s.charAt(i) + "");
            }
        }
        // 输出
        while (!stack.isEmpty())
            // 加号在后面保证是正序输出
            res = stack.pop() + res;

        return res;
    }
}
