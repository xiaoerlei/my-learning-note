package zhulei.LeetCode.No451_根据字符出现频率排序;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @Author: zl
 * @Date: 2019/9/1 13:41
 * @Description: 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 *
 *          输入: "tree"
 *
 *          输出: "eert"
 *
 *          解释:
 *              'e'出现两次，'r'和't'都只出现一次。
 *              因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 *
 */
public class Solution {

    @Test
    public void function(){
        System.out.println(frequencySort("tree"));
    }

    public String frequencySort(String s) {
        // StringBuilder来拼接，作为最后的返回结果
        StringBuilder res = new StringBuilder();

        char[] charArr = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < charArr.length; i++) {
            if(!map.containsKey(charArr[i]))
                map.put(charArr[i], 1);
            else
                map.put(charArr[i], map.get(charArr[i]) + 1);
        }

        Map<Character, Integer> sortMap = sortMapByValue(map);
        for(Map.Entry<Character, Integer> entry : sortMap.entrySet()){
            int size = entry.getValue();
            while (size > 0){
                res.append(entry.getKey());
                size--;
            }
        }

        return res.toString();
    }


    // 将最后LinkedHashMap的引用作为返回值（对String类型的value进行排序）
    public Map<Character, Integer> sortMapByValue(Map<Character, Integer> save) {
        // 首先把map的entry对象存放在list里面，再利用Collections对list进行自定义排序
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(save.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                // 对value升序排序
                return o2.getValue()- o1.getValue();
            }
        });
        // 最后因为需要链式存储，所以用LinkedHashMap来保存
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i).getKey(), list.get(i).getValue());
        }
        return map;
    }
}
