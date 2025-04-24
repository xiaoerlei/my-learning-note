package zhulei.LeetCode.No122_买股票的最佳时机II;

/**
 * @Author: zl
 * @Date: 2019/4/29 10:18
 * @Description: 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *              设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *              你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）
 */
public class TheBestChanceOfBuyStock {

    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
//        System.out.println(maxProfit(arr));
        System.out.println(peakAndValley(arr));
    }

    /*
        解法的关键是我们需要考虑到紧跟谷的每一个峰值以最大化利润。
        如果我们试图跳过其中一个峰值来获取更多利润，那么我们最终将失去其中一笔交易中获得的利润，从而导致总利润的降低
     */
    public static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i - 1])
                profit += prices[i] - prices[i - 1];
        }
        return profit;
    }


    public static int peakAndValley(int[] prices) {
        int profit = 0;
        int peak = prices[0];
        int valley = prices[0];
        int index = 1;
        // index < prices.length - 1方便在最后只剩一个数的时候可以直接跳出循环（此时再买进就没有意义了）
        while (index < prices.length - 1) {
            // 找到波谷，然后对角标进行维护
            while (index < prices.length - 1 && prices[index] >= prices[index - 1])
                index++;
            valley = prices[index];
            // 找到波峰，然后对角标进行维护
            while (index < prices.length - 1 && prices[index] <= prices[index - 1])
                index++;
            peak = prices[index];
            // 计算最大利益
            profit += peak - valley;
        }

        return profit;
    }
}
