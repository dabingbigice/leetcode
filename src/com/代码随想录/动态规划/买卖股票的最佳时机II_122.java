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
        // 创建二维数组存储状态
        // 注意：这里dp[i][0]和dp[i][1]的含义可能与常规理解不同
        // 根据股票问题的标准解法，通常dp[i][0]表示第i天不持有股票，dp[i][1]表示第i天持有股票
        int[][] dp = new int[n][2];
        // 初始状态
        dp[0][0] = -prices[0];  // 第0天持有股票：即买入第0天的股票，利润为-prices[0]
        dp[0][1] = 0;           // 第0天不持有股票：即不进行任何操作，利润为0
        for (int i = 1; i < n; ++i) {
            // 第i天持有股票的最大利润：
            // 1. 保持前一天已持有的股票 (dp[i-1][0])
            // 2. 前一天不持有股票，今天买入 (dp[i-1][1] - prices[i])
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            // 第i天不持有股票的最大利润：
            // 1. 保持前一天已不持有股票的状态 (dp[i-1][1])
            // 2. 前一天持有股票，今天卖出 (dp[i-1][0] + prices[i])
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        // 返回最后一天不持有股票的最大利润
        // 因为在股票交易中，最终不持有股票通常能获得更高收益（避免了持仓风险）
        return dp[n - 1][1];
    }

}
