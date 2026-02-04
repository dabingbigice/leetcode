package com.代码随想录.二刷.动态规划.完全背包;

import java.util.Arrays;

public class _322零钱兑换 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        if (amount == 0) return 0;
        //0有0方法
        Arrays.fill(dp, 1000000);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[amount] == 1000000 ? -1 : dp[amount];
    }
}
