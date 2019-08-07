package zhulei.LeetCode.No22_括号生成;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zl
 * @Date: 2019/8/6 17:43
 * @Description: 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 *          例如，给出 n = 3，生成结果为：
 *
 *                      [
 *                          "((()))",
 *                          "(()())",
 *                          "(())()",
 *                          "()(())",
 *                          "()()()"
 *                      ]
 */
public class Solution {

    @Test
    public void function(){
        System.out.println(generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backTrace(res, "", 0, 0, n);

        return res;
    }

    // 回溯法
    private void backTrace(List<String> res, String curStr, int left, int right, int n) {
        if (curStr.length() == n * 2){
            res.add(curStr);
            return;
        }

        // 判断顺序保证每次是先添加left，再添加right，这样括号就能配对成功
        if (left < n)
            backTrace(res, curStr + "(", left + 1, right, n);

        if (right < left)
            backTrace(res, curStr + ")", left, right + 1, n);
    }
}
