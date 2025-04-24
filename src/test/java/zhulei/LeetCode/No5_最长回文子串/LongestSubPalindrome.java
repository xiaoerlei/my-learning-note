package zhulei.LeetCode.No5_最长回文子串;

/**
 * @Author: zl
 * @Date: 2019/3/4 12:56
 * @Description:
 */
public class LongestSubPalindrome {

    public static void main(String[] args) {
        String s = "aacdefcaa";
        System.out.println(longestPalindrome(s));
        System.out.println(longestPalindromeDP(s));
        System.out.println(longestPalindromeEx(s));
    }

    /**
     *  回文判断，可以用原字符串和对应的逆序字符串来包含比较
     *  abcb -> bcba
     *  其中只有bcb可能包含对称关系
     *  在逆序字符串 bcba 中判断是否包含 bcb
     */
    public static String longestPalindrome(String s) {

        StringBuilder sb = new StringBuilder(s);
        String reverseStr = sb.reverse().toString();    // 用于存放参数的逆字符串，作为镜像比较
        String res = "";
        int count = 0;
        int max = 0;
        int start, end;     // 两根指针，分别指向原始字符串的开头和结尾
        for (int i = 0; i < s.length(); i++) {
            start = i;      // 初始化头指针和尾指针
            for (end = s.length(); ; end--) {
                count = end - start;
                if(count <= 0)    break;
                // 每次都对字符串头尾指向的指针进行切割
                String subStr = s.substring(start, end);
                // 重点判断头尾的两个元素是否相等，相等的话即为回文字符串
                if(subStr.charAt(0) == subStr.charAt(subStr.length() - 1) && reverseStr.contains(subStr) && count > max){
                    res = subStr;
                    max = count;
                }
            }
        }
        return res;
    }


    /**
     * dp 解法
     *
     * dp[i][j]表示 i 到 j 这个区间段是否是回文。子问题划分
     */
    public static String longestPalindromeDP(String s) {
        String res = "";
        int n = s.length();
        // 保存 i 到 j 范围内的字串，是否是回文子串
        boolean[][] dp = new boolean[n][n];

        // 因为先要确定 i + 1 之后，才能确定 i，所以第一层循环需要从后往前遍历
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                // 首先判断当前 i 和 j 对应索引位置的字符是否相等，如果相等再判断其子串。
                // j - i < 2是子串长度小于等于2的情况，这种情况一定是回文的
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1]);
                // 如果是回文，则取最大长度
                if(dp[i][j] && j - i + 1 > res.length())
                    res = s.substring(i, j + 1);
            }
        }

        return res;
    }


    /**
     * 扩展中心解法
     *
     */
    public static String longestPalindromeEx(String s) {
        if(s == null || s.length() == 0)
            return "";

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            // 偶数回文个数情况下的回文串长度
            int len1 = centerExpand(s, i, i);
            // 奇数回文个数情况下的回文串长度
            int len2 = centerExpand(s, i, i + 1);
            // 取最大结果
            int len = Math.max(len1, len2);
            // 如果当前长度大于之前更新的最大长度，则对长度进行更新
            if(len > (end - start)){
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private static int centerExpand(String res, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < res.length() && res.charAt(L) == res.charAt(R)){
            L--;
            R++;
        }
        return R - L - 1;
    }
}
