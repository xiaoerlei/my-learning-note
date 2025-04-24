package zhulei.JianZhiOffer.No33_丑数;

/**
 * @Author: zl
 * @Date: 2019/5/31 17:08
 * @Description: 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 *          例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。
 *          求按从小到大的顺序的第N个丑数。
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution(10));
    }

    /*
        思路：
            定义三个队列。分别用于存放与2、3、5的乘积。再定义一个数组，用于存放从小到大的丑数

            每次选取三个队列中最小的值，出队（移动数组的角标），然后将出队的元素存放在丑数数组中
            对于出队的元素，可能每次迭代会出现不止一个元素出队，这个时候只用判断当前丑数数组的值跟三个队列中出队的元素是否相等
            如果相等，则移动数组角标，如果不等则数组角标维持不变
            最后丑数数组中的第index个元素即为第index个丑数
     */
    public static int GetUglyNumber_Solution(int index) {
        if(index <= 6)
            return index;
        // 定义2、3、5的索引下标
        int i2 = 0, i3 = 0, i5 = 0;
        int[] res = new int[index];
        res[0] = 1;
        for (int i = 1; i < index; i++) {
            // 每次取出三个队列中，队头最小的元素，出队，然后保存在数组中
            res[i] = Math.min(res[i2] * 2, Math.min(res[i3] * 3, res[i5] * 5));
            // 对于出队的数组，指针向后移动一位（如果当前两个或者三个数值一样，则同时出队，并且同时移动一位指针）
            if(res[i] == res[i2] * 2)   i2++;
            if(res[i] == res[i3] * 3)   i3++;
            if(res[i] == res[i5] * 5)   i5++;
        }
        return res[index - 1];
    }
}
