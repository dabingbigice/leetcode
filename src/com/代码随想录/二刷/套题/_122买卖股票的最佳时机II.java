package com.代码随想录.二刷.套题;

import java.util.Arrays;

public class _122买卖股票的最佳时机II {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];//持有
        dp[0][1] = 0;//不持有
        for (int i = 1; i < prices.length; i++) {
            //(前一天持有，当天持有)  当天持有=前一天不持有的钱-当天股票的价格
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            //(前一天不持有，当天卖出)
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[prices.length - 1][1];

    }

    public int maxProfit1(int[] prices) {
        int[] dp = new int[prices.length];
        if (prices.length < 2) return 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 1] + prices[i] - prices[i - 1]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[prices.length - 1];
    }
}
