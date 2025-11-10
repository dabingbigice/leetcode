package com.代码随想录.动态规划;

import java.util.Arrays;

public class 买卖股票的最佳时机II_122 {
    public int maxProfit(int[] prices) {
        //1.定义dp[i]:第i天的最大利润
        //2.初始化dp[0]=-price[0]
        if (prices.length == 1) return 0;
        int dp[] = new int[prices.length];
        dp[1] = Math.max(prices[1] - prices[0], 0);
        for (int i = 2; i < prices.length; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] - prices[i - 1] + dp[i - 1]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[prices.length - 1];
    }
    public int maxProfit1(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];     // 创建二维数组存储状态
        dp[0][0] = 0;                   // 初始状态
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);    // 第 i 天，没有股票
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);    // 第 i 天，持有股票
        }
        return dp[n - 1][0];    // 卖出股票收益高于持有股票收益，因此取[0]
    }

}
