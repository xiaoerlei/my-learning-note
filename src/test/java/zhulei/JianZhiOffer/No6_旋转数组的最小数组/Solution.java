package zhulei.JianZhiOffer.No6_旋转数组的最小数组;

/**
 * @Author: zl
 * @Date: 2019/5/24 23:22
 * @Description: 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *              输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 *              例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 *              NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2};
        System.out.println(minNumberInRotateArray(arr));
    }
    /*
        思路：
            首先根据题目意思，可以得到的信息就收旋转数组是一个基本有序的数组（{1,1,1,0,1}这个数组是有序，但不递增），被一分为二
            所以能推出，数组被均分为二的话，其中一个数组会存在第一个元素大于最后一个元素，即{3,4,5,1,2}中，{5,1,2}中5大于2
            这样就能提高查询的效率，直接得到最小的数字在这个部分里面（对应{5,1,2}）

            最后对于特殊情况，{1,1,1}，和{1,0,1}。则遍历整个数组
     */
    public static int minNumberInRotateArray(int [] array) {
        int low = 0;
        int high = array.length - 1;
        while (high > low){
            // 每次取中间的长度，作为中间角标
            int midddle = low + (high - low) / 2;
            // 对于特殊情况的处理
            if(array[low] == array[midddle] && array[midddle] == array[high])
                return minNumberInRotateArray(array, low, high);
            // 如果后半个数组中，第一个值小于等于最后一个值。则说明最小值应该存在另前半个值数组中
            // 即把最大值指针指向middle
            // 关于为什么一定要判断是否在后半个数组里，是因为如果直接把目标放到后半个数组会导致判断丢失。而判断后半个数组之前，第一部判断会先行执行前半个数组最前最后两个值是否相等
            else if(array[midddle] <= array[high])
                high = midddle;
            // 反之最小值就在后半个数组，最小值指针指向middle
            else
                low = midddle + 1;
        }
        return array[low];
    }

    private static int minNumberInRotateArray(int[] array, int low, int high) {
        int min = array[low];
        for (int i = low; i < high; i++) {
            min = Math.min(min, array[i]);
        }
        return min;
    }

}
