package zhulei.LeetCode.No123_买股票的最佳时机III;

/**
 * @Author: zl
 * @Date: 2019/4/29 12:26
 * @Description: 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *              设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 *              注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）
 */
public class TheBestChanceOfBuyStock {

    public static void main(String[] args) {
        int[] arr = {3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(arr));
    }


    public static int maxProfit(int[] prices) {
        int profit = 0;
        if(prices.length == 0) {
            return 0;
        }

        int[] leftMaxProfit = new int[prices.length];//前i天中最大的
        int minPrice = prices[0];//买入最低价格
        for(int i = 1 ;i < prices.length;i++) {
            if(minPrice > prices[i]) {
                minPrice = prices[i];
            }
            leftMaxProfit[i] = Math.max(prices[i]-minPrice,leftMaxProfit[i-1]);
        }


        int[] rightMaxProfit = new int[prices.length]; //后i天中最大的
        int maxPrice = prices[prices.length - 1];//卖出最高价格
        for(int i = prices.length-2;i>0;i--) {
            if(maxPrice < prices[i]) {
                maxPrice = prices[i];
            }
            rightMaxProfit[i] = Math.max(maxPrice-prices[i],rightMaxProfit[i+1]);
        }

        for(int i = 0;i < prices.length;i++) {
            profit = Math.max(profit,leftMaxProfit[i] +rightMaxProfit[i] );
        }
        return profit;
    }
}
