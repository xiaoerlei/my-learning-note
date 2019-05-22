package zhulei.LeetCode.No11_盛最多水的容器;

/**
 * @Author: zl
 * @Date: 2019/5/9 19:19
 * @Description: 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 *          在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 *          找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 */
public class TheMaxArea {

    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr));
        System.out.println(otherSolution(arr));
    }

    // 暴力求解发的思路（O(n^2)）
    public static int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        // 从左到右依次寻找。保证左边边界存大于等于当前右边的边界时，为当前坐标下的最大容量
        for (int i = 0; i < height.length; i++) {
            int count = 0;
            int factor = 0;
            for (int j = i + 1; j < height.length; j++) {
                count++;
                // 如果存在右边大于等于左边，则保留此次的乘积因子
                if(height[j] >= height[i]){
                    factor = count;
                }
            }
            max = Math.max(max, height[i] * factor);    // 计算最大容量
        }
        // 从右到左依次寻找。保证右边边界存大于等于当前左边的边界时，为当前坐标下的最大容量
        for (int i = height.length - 1; i >= 0; i--) {
            int count = 0;
            int factor = 0;
            for (int j = i - 1; j >= 0; j--) {
                count++;
                if(height[j] >= height[i]){
                    factor = count;
                }
            }
            max = Math.max(max, height[i] * factor);    // 比较从左往右和从右往左的最大容量
        }
        return max;
    }

    // O（n）解法。每次挪动左端或者右端的指针，然后计算保存当前的最大值。
    public static int otherSolution(int[] height) {
        int max = 0;
        for(int i = 0, j = height.length - 1; i < j; ){
            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
            max = Math.max(max, (j - i + 1) * minHeight);
        }
        return max;
    }

}

