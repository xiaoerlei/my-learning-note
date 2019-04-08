package zhulei.JavaNote.Java集合.Map集合中对value进行排序;

import java.util.*;

/**
 * @Author: zl
 * @Date: 2019/4/4 17:53
 * @Description: 主要利用Collections方法来对值进行排序，关键利用List来保存Entry数组
 */
public class MapSortByValue {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("jieyin", 25);
        map.put("longshao", 26);
        map.put("zzq", 24);

        Map<String, Integer> afterSort = sortMapByValue(map);
        
        printMap(afterSort);

        printFirstN(2, afterSort);
    }

    // 打印Map的前N个元素
    private static void printFirstN(int i, Map<String, Integer> afterSort) {
        int count = 0;
        for(Map.Entry<String, Integer> entry : afterSort.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
            count++;
            if(count == i)
                break;
        }
    }

    // 打印Map集合
    private static void printMap(Map<String, Integer> afterSort) {
        for (Map.Entry<String, Integer> entry : afterSort.entrySet())
            System.out.println(entry.getKey() + " " + entry.getValue());
    }

    // 对Value进行排序
    private static Map<String, Integer> sortMapByValue(Map<String, Integer> save) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(save.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i).getKey(), list.get(i).getValue());
        }
        return map;
    }
}
