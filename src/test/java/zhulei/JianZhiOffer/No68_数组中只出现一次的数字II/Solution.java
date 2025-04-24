package zhulei.JianzhiOffer.No68_数组中只出现一次的数字II;

import org.junit.jupiter.api.Test;

/**
 * @Author: zl
 * @Date: 2022/8/6 18:51
 * @Description: 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字
 */
public class Solution {

    @Test
    void fun() {
        int[] arr = {9, 1, 7, 9, 7, 9, 7};
        System.out.println(singleNumber(arr));
    }


    public int singleNumber(int[] nums) {
        // 记录所有数字的各二进制位 1 的出现次数
        int[] counts = new int[32];
        for(int num : nums) {
            for(int j = 0; j < 32; j++) {
                counts[j] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0, m = 3;
        // 将 counts 各元素对 3 求余，则结果为 只出现一次的数字 的各二进制位
        for(int i = 0; i < 32; i++) {
            // 利用 左移 和 或，可将 counts 数组中各二进位的值恢复到数字 res 上
            res <<= 1;
            res |= counts[31 - i] % m;
        }
        return res;
    }
}
