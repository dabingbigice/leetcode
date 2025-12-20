package com.代码随想录.二刷.完全背包;

public class _518零钱兑换II {
    public int change(int amount, int[] coins) {
        //背包容量
        int dp[] = new int[amount + 1];
        //装下0的方法有1种
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i] <= j)
                    dp[j] = dp[j] + dp[j - coins[i]];
            }
        }
        return dp[amount];
    }

}
