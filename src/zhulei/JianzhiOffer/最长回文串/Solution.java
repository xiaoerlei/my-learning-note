package zhulei.JianzhiOffer.最长回文串;

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
            int len1 = expand(str, i, i);
            int len2 = expand(str, i, i+1);
            int len = Math.max(len1, len2);
            if(len > end - start){
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return str.substring(start, end + 1);
    }

    public static int expand(String s, int left, int right){
        int L = left, R = right;
        while(L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)){
            L--;
            R++;
        }
        return R - L - 1;
    }

}
