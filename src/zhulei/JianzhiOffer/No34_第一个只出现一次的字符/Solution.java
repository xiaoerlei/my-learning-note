package zhulei.JianzhiOffer.No34_第一个只出现一次的字符;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: zl
 * @Date: 2019/6/5 16:32
 * @Description: 在一个字符串(0 <= 字符串长度 <= 10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(FirstNotRepeatingChar("googgle"));
    }

    // 用Map的键值思想来解决，LinkedHashMap保证有序
    public static int FirstNotRepeatingChar(String str) {
        if(str.length() == 0)
            return -1;

        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if(!map.containsKey(Character.toString(str.charAt(i)))) {
                map.put(Character.toString(str.charAt(i)), 1);
            } else {
                map.put(Character.toString(str.charAt(i)), map.get(Character.toString(str.charAt(i))) + 1);
                // 保证重复元素不会被覆盖
                map.put(Character.toString(str.charAt(i)) + i, map.get(Character.toString(str.charAt(i))) + 1);
            }
        }

        int index = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1)
                return index;
            index++;
        }
        return -1;
    }

    // 下面是利用ascll码的思路来做的，不过因为ascll码是有序的，所以只能判断出现一次的字符，但是无法判断是否是第一次出现
    /*
        char[] charArr = str.toCharArray();
        char[] ascll = new char[128];
        for (int i = 0; i < charArr.length; i++)
            ascll[charArr[i]]++;

        // 在ASCll数组里面查询只出现过一次的数值，就表示只出现了一次
        for (int i = 0; i < ascll.length; i++)
            if(ascll[i] == 1)
                // 将ASCll的数值重新转化为char，直接强制转换就可以了
                return str.indexOf(String.valueOf((char) i));
     */
}
