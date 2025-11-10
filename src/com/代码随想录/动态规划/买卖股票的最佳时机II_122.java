package com.代码随想录.动态规划;

import java.util.Arrays;

public class 买卖股票的最佳时机II_122 {
    public int maxProfit(int[] prices) {
        //1.定义dp[i]:第i天的最大利润
        //2.初始化dp[0]=-price[0]
        if (prices.length == 1) return 0;
        int dp[] = new int[prices.length];
        dp[1] = prices[1] - prices[0] > 0 ? prices[1] - prices[0] : 0;
        for (int i = 2; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) dp[i] = Math.max(dp[i - 1], prices[i] - prices[i - 1] + dp[i - 1]);
            else dp[i] = dp[i - 1];

        }
        System.out.println(Arrays.toString(dp));
        return dp[prices.length - 1];
    }

}
