package zhulei.JianzhiOffer.No40_数组中只出现一次的数字;

import java.util.*;

/**
 * @Author: zl
 * @Date: 2019/6/8 11:13
 * @Description: 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 *              请写程序找出这两个只出现一次的数字。
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,4,5,5,6,6};

        // O(1)的空间复杂度和O(n)的时间复杂度
        System.out.println(Arrays.toString(singleNumbers(arr)));
        System.out.println(Arrays.toString(otherSolution(arr)));

        // 不建议这种方法，不满足时间和空间复杂度
        System.out.println(Arrays.toString(FindNumsAppearOnce(arr)));
    }

    /**
     * 分组异或
     * @param nums
     * @return
     */
    public static int[] singleNumbers(int[] nums) {
        // 最终答案就是那两个只出现一次的的数异或的结果
        int ret = 0;
        for(int num : nums) {
            ret ^= num;
        }
        // 如果target第一个二进制位不为1，就将aim左移一位位0010，然后与相与，判断ret第二位是否为一
        // 按此循环，直到找到ret的第一个为1的二进制位
        // 这里目的就是为了分组，把a和b分在两组且保证两组内其他数字都恰好成对
        int aim = 1;
        while((aim & ret) == 0) {
            aim <<= 1;
        }
        int a = 0, b = 0;
        for(int num : nums) {
            // 这里是通过if...else将nums分为了两组，一边遍历一边异或来找到最终结果
            if((aim & num) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[] {a, b};
    }


    /**
     * 异或思路解题：
     *         两个不相等的元素在位级表示上必定会有一位存在不同，将数组的所有元素异或得到的结果为不存在重复的两个元素异或的结果。
     *         diff &= -diff 得到出 diff 最右侧不为 0 的位，也就是不存在重复的两个元素在位级表示上最右侧不同的那一位，利用这一位就可以将两个元素区分开来。
     * @param nums
     * @return
     */
    public static int[] otherSolution(int[] nums) {
        int diff = 0;
        for (int num : nums)
            diff ^= num;
        diff &= -diff;
        int num1 = 0, num2 = 0;
        for (int num : nums) {
            if ((num & diff) == 0)
                num1 ^= num;
            else
                num2 ^= num;
        }
        return new int[] {num1, num2};
    }

    // num1,num2分别为长度为1的数组。传出参数
    public static int[] FindNumsAppearOnce(int [] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if(map.containsKey(array[i]))
                map.put(array[i], map.get(array[i]) + 1);
            else
                map.put(array[i], 1);
        }

        // 用map来存储，出现的数字和次数。LinkedHashMap来接收对value排好序后的map
        LinkedHashMap<Integer, Integer> sortMap = sortValue(map);
        int count = 0;
        int num1 = 0, num2 = 0;
        // 最后接收前两个key值
        for(Map.Entry<Integer, Integer> entry : sortMap.entrySet()){
            count++;
            if(count == 1)
                num1 = entry.getKey();
            else if(count == 2)
                num2 = entry.getKey();
            else
                break;
        }
        return new int[] {num1, num2};
    }

    /*
        对value进行排序
        用list来保存所有的Entry对象中，而Entry对象中包含key和value
        再在Collections中实现Comparator接口，就可以按照指定要求来排序，可对value排序
        对list排序后，在按顺序存储list中Entry，就能得到指定value顺序的map了
     */
    private static LinkedHashMap<Integer, Integer> sortValue(HashMap<Integer, Integer> map) {
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        LinkedHashMap<Integer, Integer> sortMap = new LinkedHashMap<>();
        for (int i = 0; i < list.size(); i++)
            sortMap.put(list.get(i).getKey(), list.get(i).getValue());

        return sortMap;
    }

}
