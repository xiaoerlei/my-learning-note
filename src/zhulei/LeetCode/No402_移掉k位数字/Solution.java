package zhulei.LeetCode.No402_移掉k位数字;

import org.junit.jupiter.api.Test;

/**
 * @Author: zl
 * @Date: 2019/9/22 12:07
 * @Description:
 */
public class Solution {

    @Test
    public void function(){
        System.out.println(removeKdigits("1432219", 3));
    }

    public String removeKdigits(String num, int k) {
        if(num.length() <= k)   return "0";

        StringBuilder sb = new StringBuilder(num);
        for(int i = 0; i < k; i++){
            int index = 0;
            for(int j = 1; j < sb.length() && sb.charAt(j) >= sb.charAt(j - 1); j++)
                index = j;
            sb.delete(index, index + 1);

            // 去0
            while(sb.length() > 1 && sb.charAt(0) == '0')
                sb.delete(0, 1);
        }

        return sb.toString();
    }
}
