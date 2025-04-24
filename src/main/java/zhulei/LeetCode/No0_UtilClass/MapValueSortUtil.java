package zhulei.LeetCode.No0_UtilClass;

import java.util.*;

/**
 * @Author: zl
 * @Date: 2019/9/1 0:39
 * @Description: map对value进行排序
 */
public class MapValueSortUtil {


    // 将最后LinkedHashMap的引用作为返回值（对int类型的value进行排序）
    public Map<Integer, Integer> sortMapByIntegerValue(Map<Integer, Integer> save) {
        // 首先把map的entry对象存放在list里面，再利用Collections对list进行自定义排序
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(save.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                // 对value升序排序
                return o1.getValue() - o2.getValue();
            }
        });
        // 最后因为需要链式存储，所以用LinkedHashMap来保存
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i).getKey(), list.get(i).getValue());
        }
        return map;
    }

    // 将最后LinkedHashMap的引用作为返回值（对String类型的value进行排序）
    public Map<String, Integer> sortMapByStringValue(Map<String, Integer> save) {
        // 首先把map的entry对象存放在list里面，再利用Collections对list进行自定义排序
        List<Map.Entry<String, Integer>> list = new ArrayList<>(save.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                // 对value升序排序
                return o1.getValue() - o2.getValue();
            }
        });
        // 最后因为需要链式存储，所以用LinkedHashMap来保存
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i).getKey(), list.get(i).getValue());
        }
        return map;
    }

    // 将最后LinkedHashMap的引用作为返回值（对Character类型的value进行排序）
    public Map<Character, Integer> sortMapByCharValue(Map<Character, Integer> save) {
        // 首先把map的entry对象存放在list里面，再利用Collections对list进行自定义排序
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(save.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                // 对value降序排序
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
