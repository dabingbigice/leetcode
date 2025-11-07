package com.note.动态规划;

import java.util.Arrays;

public class 零钱兑换_322 {
    public int coinChange(int[] coins, int amount) {
        //定义dp[j]:容量为j的背包能满且装下最小数量的物品
        int[] dp = new int[amount + 1];
        for (int j = 0; j < dp.length; j++) {
            dp[j] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {//物品
            for (int j= coins[i]; j <= amount; j++) {//背包
                if (dp[j - coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], 1 + dp[j - coins[j]]);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }

    public static void main(String[] args) {
        new 零钱兑换_322().coinChange(new int[]{1, 2, 5}, 11);
    }
}
