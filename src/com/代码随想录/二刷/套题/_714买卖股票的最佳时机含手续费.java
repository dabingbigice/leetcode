package com.代码随想录.二刷.套题;

public class _714买卖股票的最佳时机含手续费 {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        //持有
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            //先买到一个最低的价格，卖出之后就有利润了，持有的值就会一直变大
            // max(前一天持有的钱（保持），前一天不持有的总钱-今天的价格（买入）)。持有
            //只要不随便买入，就不会出错。
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);//只有利润递增这个式子才会改变，
            //max(前一天不持有的钱，前一天持有的钱(保持)+今天的价格-fee（卖出）),不持有
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
        }
        return dp[prices.length - 1][1];
    }
}
