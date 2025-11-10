package com.代码随想录.动态规划;

import java.util.Arrays;

public class 买卖股票的最佳时机_121 {
    /**
     * 计算一次股票交易的最大利润（LeetCode 121.买卖股票的最佳时机）
     * @param prices 股票价格数组，prices[i]表示第i天的股票价格
     * @return 最大利润，如果无法盈利则返回0
     */
    public int maxProfit(int[] prices) {
        // 边界情况检查：如果价格数组为空或只有一天，无法进行交易
        if (prices == null || prices.length <= 1) return 0;

        // 1. DP数组定义
        // dp[i][0]: 第i天结束时持有股票的最大利润
        // dp[i][1]: 第i天结束时不持有股票的最大利润
        int[][] dp = new int[prices.length][2];

        // 2. 初始化第一天的情况
        dp[0][0] = -prices[0];  // 第一天买入股票，利润为负的股价
        dp[0][1] = 0;           // 第一天不持有股票，利润为0

        // 3. 动态规划过程，从第二天开始遍历
        for (int i = 1; i < prices.length; i++) {
            // 第i天持有股票的最大利润 = max(前一天就持有, 今天刚买入)
            // 注意：只能交易一次，所以今天买入时的成本就是-prices[i]（不是基于之前利润）
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);

            // 第i天不持有股票的最大利润 = max(前一天就不持有, 前一天持有今天卖出)
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }

        // 调试输出，显示最后一天的DP状态（可删除）
        System.out.println(Arrays.toString(dp[dp.length - 1]));

        // 4. 返回最终结果：最后一天不持有股票的最大利润
        return dp[prices.length - 1][1];  // 修正：应该返回[1]而不是[0]
    }
}
