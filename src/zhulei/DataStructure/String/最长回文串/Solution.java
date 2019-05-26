package zhulei.DataStructure.String.最长回文串;

/**
 * @Author: zl
 * @Date: 2019/4/30 21:27
 * @Description: 返回最长镜像对称回文子串
 */
public class Solution {

    public static void main(String[] args) {
        String str = "ABCBADFNHNFDA";
        System.out.println(getPalindromeLength(str));
    }

    public static String getPalindromeLength(String str){
        if(str == null || str.length() < 1) return "";
        int start = 0, end = 0;
        for(int i = 0; i < str.length(); i++){
            // 奇数的情况下，寻找回文子串
            int lenOdd = expand(str, i, i);
            // 偶数的情况下，寻找回文子串
            int lenEven = expand(str, i, i + 1);
            // 找到最长的回文子串的长度
            int len = Math.max(lenOdd, lenEven);
            // 只有在len大于之前的长度的时候，再重新设定需要截取的 起始位置 和 终点位置 的索引
            if(len > end - start){
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return str.substring(start, end + 1);
    }

    public static int expand(String s, int left, int right){
        int L = left, R = right;
        // 在限定条件下，如果左右两边的字符相同，则左右两边的指针同时向左右两边移动
        while(L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)){
            L--;
            R++;
        }
        return R - L - 1;
    }

}
