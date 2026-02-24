package com.note.记忆化搜索;

import java.util.Arrays;

public class _121_买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        dp = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        if (prices.length == 1) return 0;
        return dfs(prices, 0, 0);
    }

    int[][] dp;

    int dfs(int[] prices, int s, int idx) {
        // 递归终止条件：处理完所有天数或进入完成状态
        if (idx == prices.length || s == 2) return 0;
        // 记忆化检查：如果当前状态已计算过，直接返回结果
        if (dp[idx][s] != -1) return dp[idx][s];

        // 根据当前状态s进行分支决策
        if (s == 0)
            // 状态0（未持有股票）：可选择「保持空仓」或「买入」
            // Math.max(保持空仓, 买入股票并转入状态1)
            return dp[idx][s] = Math.max(
                    dfs(prices, 0, idx + 1),       // 不操作，继续状态0
                    dfs(prices, 1, idx + 1) - prices[idx] // 买入，转入状态1，支出prices[idx]
            );


        // 状态1（持有股票）：可选择「继续持有」或「卖出」
        // Math.max(继续持有, 卖出股票并转入状态2)
        return dp[idx][s] = Math.max(
                dfs(prices, 1, idx + 1),       // 不操作，继续状态1
                dfs(prices, 2, idx + 1) + prices[idx]  // 卖出，转入状态2，收入prices[idx]
        );
    }

}
