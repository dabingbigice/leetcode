package com.代码随想录.动态规划;

public class 买卖股票的最佳时机含手续费_714 {
    public int maxProfit(int[] prices, int fee) {
        // 创建动态规划数组dp
        // dp[i][0] 表示第i天结束时持有股票的最大利润
        // dp[i][1] 表示第i天结束时不持有股票的最大利润[1,2,3](@ref)
        int[][] dp = new int[prices.length][2];
        // 初始化第一天的状态[2,4](@ref)
        dp[0][0] = -prices[0];  // 第一天买入股票，利润为负的股价（成本）
        dp[0][1] = 0;           // 第一天不操作，利润为0
        // 从第二天开始遍历每一天
        for (int i = 1; i < prices.length; i++) {
            // 状态转移1：第i天持有股票的最大利润
            // 选择1：保持前一天的持股状态（dp[i-1][0]）
            // 选择2：前一天不持股，今天买入股票（dp[i-1][1] - prices[i]）
            // 取两者中较大值，表示最优决策[1,3](@ref)
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            // 状态转移2：第i天不持有股票的最大利润
            // 选择1：保持前一天的空仓状态（dp[i-1][1]）
            // 选择2：前一天持股，今天卖出股票（dp[i-1][0] + prices[i] - fee）
            // 卖出时需要支付手续费fee[2,4](@ref)
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
        }
        // 最终返回最后一天不持有股票的最大利润
        // 因为在股票交易问题中，最终不持有股票通常能获得最大利润[1,3](@ref)
        return dp[prices.length - 1][1];
    }
}
