package com.代码随想录.二刷.套题;

public class _121买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        //持有
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(-prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
        }
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
    }

    public int maxProfit1(int[] prices) {
        int cost = Integer.MAX_VALUE;
        int profit = 0;
        for (int price : prices) {
            cost = Math.min(price, cost);
            profit = Math.max(price, price - cost);
        }
        return profit;

    }
}
