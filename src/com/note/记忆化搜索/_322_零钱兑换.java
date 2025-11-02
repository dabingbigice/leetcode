package com.note.记忆化搜索;

import java.util.Arrays;

public class _322_零钱兑换 {
    public int coinChange(int[] coins, int amount) {
        dp = new int[amount+1];
        Arrays.fill(dp, -1);
        int ans = dfs(0,coins,amount);
        return ans == 10010 ? -1 : ans;
    }

    int dp[];

    int dfs(int cur, int[] coins, int amount) {
//        ==表示这一步有效，！=表示超过了，返回一个大值让min取不到
        if (cur >= amount) return cur == amount ? 0 : 10010;
        if (dp[cur] != -1) return dp[cur];
        int ans = 10010;
        for (int i = 0; i < coins.length; i++) {
            if(coins[i]<=amount-cur) ans = Math.min(dfs(cur + coins[i], coins, amount) + 1, ans);
        }
        return dp[cur] = ans;
    }
}
