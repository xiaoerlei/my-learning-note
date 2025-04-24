package zhulei.LeetCode.No131_分割回文串;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zl
 * @Date: 2019/8/18 23:26
 * @Description: 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *          返回 s 所有可能的分割方案。
 *
 *          输入: "aab"
 *          输出:
 *          [
 *              ["aa","b"],
 *              ["a","a","b"]
 *          ]
 *
 */
public class Solution {

    @Test
    public void function(){
        System.out.println(partition("aab"));
    }


    List<List<String>> lists = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if("".equals(s))
            return lists;

        List<String> list = new ArrayList<>();
        backTrace(0, s.length(), s, list);

        return lists;
    }

    private void backTrace(int index, int length, String str, List<String> resSet) {
        if(index == length && resSet.size() > 0){
            // 这里需要每次创建一个新的对象，否则会存在对象引用问题
            lists.add(new ArrayList<>(resSet));
            return;
        }

        // 这里会有 i < length 的判断，并且递归每次都会+1，所以不用担心递归溢出问题
        for (int i = index; i < length; i++) {
            if(isPalindrome(str, index, i)) {
                // 先把符合条件的字符串添加到子集合中
                resSet.add(str.substring(index, i + 1));
                backTrace(i + 1, length, str, resSet);
                // 如果不符合最终条件，则回退到上一步（还原状态）
                resSet.remove(resSet.size() - 1);
            }
        }
    }

    // 判断是否回文
    private boolean isPalindrome(String s, int firstIndex, int lastIndex) {
        while (firstIndex < lastIndex)
            if(s.charAt(firstIndex++) != s.charAt(lastIndex--))
                return false;

        return true;
    }


}
