package zhulei.DataStructure.Search.二分查找;

import org.junit.jupiter.api.Test;

/**
 * @Author: zl
 * @Date: 2019/6/6 16:04
 * @Description:  二分查找的递归和非递归实现
 */
public class BinarySearch {

    @Test
    public void fun(){
        int[] arr = {3,5,11,17,21,23,28,30,32,50,64,78,81,95,101};
        System.out.println(binarySearch(arr, 0, arr.length - 1, 22));
        System.out.println(binarySearch(arr, 50));

        int[] dupArr = {1,1,1,2,2,3,3,4,5,5,5,6,6};
        System.out.println(findFirstElement(dupArr, 2));
        System.out.println(findLastElement(dupArr, 2));
    }

    /**
     * 递归实现
     *
     * @param arr： 查找数组
     * @param start： 查找范围的起始下标
     * @param end： 查找范围的结束下标
     * @param key： 查找值
     * @return 返回查找结果对应的数组索引，如果没有查到返回-1
     */
    public int binarySearch(int[] arr, int start, int end, int key) {
        int mid = start + (end - start) / 2;

        if(start > end)
            return -1;

        if(arr[mid] == key)
            return mid;
        else if(arr[mid] > key)
            return binarySearch(arr, start, mid - 1, key);
        else
            return binarySearch(arr, mid + 1, end, key);

    }

    /**
     * 非递归实现
     *
     * @param arr： 查找数组
     * @param key： 查找值
     * @return 返回查找结果对应的数组索引，如果没有查到返回-1
     */
    public int binarySearch(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;
        int mid = arr.length / 2;

        if(start > end)
            return -1;

        while (end > start){
            if(arr[mid] == key)
                return mid;
            else if(arr[mid] > key)
                end = mid - 1;
            else
                start = mid + 1;

            mid = start + (end - start) / 2;
        }

        return -1;
    }

    /**
     * 如果数组中存在重复的元素，查找第一次出现的元素
     *
     * @param dupArr： 存在重复元素的数组
     * @param key： 查找值
     * @return 返回查找结果对应的数组索引，如果没有查到返回-1，如果查找到则返回第一次出现的索引
     */
    private int findFirstElement(int[] dupArr, int key) {
        int start = 0;
        int end = dupArr.length - 1;
        int mid = dupArr.length / 2;

        if(start > end)
            return -1;

        while (start < end){
            if(dupArr[mid] >= key)  // 注意，这里需要加上等于号
                end = mid;  // 保留二分后，右端点的值
            else
                start = mid + 1;

            mid = start + (end - start + 1) / 2;    // 括号中要+1，维护保留端点的情况
        }

        if(key == dupArr[mid])
            return mid;
        return -1;
    }

    /**
     * 如果数组中存在重复的元素，查找最后一次出现的元素
     *
     * @param dupArr： 存在重复元素的数组
     * @param key： 查找值
     * @return 返回查找结果对应的数组索引，如果没有查到返回-1，如果查找到则返回最后一次出现的索引
     */
    private int findLastElement(int[] dupArr, int key) {
        int start = 0;
        int end = dupArr.length - 1;
        int mid = dupArr.length / 2;

        if(start > end)
            return -1;

        while (start < end){
            if(dupArr[mid] <= key)
                start = mid;
            else
                end = mid - 1;

            mid = start + (end - start + 1) / 2;
        }

        if(key == dupArr[mid])
            return mid;
        return -1;
    }
}


