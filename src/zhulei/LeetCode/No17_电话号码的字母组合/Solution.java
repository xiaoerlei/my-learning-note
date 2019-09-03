package zhulei.LeetCode.No17_电话号码的字母组合;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zl
 * @Date: 2019/8/18 21:27
 * @Description: 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *          给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *          输入："23"
 *          输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 *          说明: 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */
public class Solution {

    @Test
    public void function(){
        System.out.println(letterCombinations(""));
    }

    List<String> list = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.equals(""))
            return list;

        findCombination(digits, 0, "");

        return list;
    }

    /**
     * @param digits: 输入参数
     * @param index：字符串的长度指针
     * @param s：拼凑字符串
     */
    private void findCombination(String digits, int index, String s) {
        if(index == digits.length()) {
            list.add(s);
            return;
        }

        int letterIndex = digits.charAt(index) - '0';   // 获取输入参数的某个字母对应字典的索引
        String letter = letterMap[letterIndex];         // 获取对应索引的字符串
        for (int i = 0; i < letter.length(); i++)
            findCombination(digits, index + 1, s + letter.charAt(i));

    }

    // 字符字典
    String[] letterMap = {
        " ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
}
