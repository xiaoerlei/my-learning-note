package zhulei.LeetCode.No121_买股票的最佳时机I;

/**
 * @Author: zl
 * @Date: 2019/4/29 11:25
 * @Description: 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *              如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *              注意你不能在买入股票前卖出股票。
 */
public class TheBestChanceOfBuyStock {

    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        System.out.println(maxProfit(arr));
    }

    private static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                profit = Math.max(prices[j] - prices[i], profit);
            }
        }
        return profit;
    }

    private static int otherSolution(int[] prices) {
        // 首先让最小价值为最大值，再不断和一些小于它的值比较，然后再置为比它小的那个值
        int minprice = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > profit) // 每次都记录下最大的利益，然后再回头去寻找最小的价格
                profit = prices[i] - minprice;
        }
        return profit;
    }
}
