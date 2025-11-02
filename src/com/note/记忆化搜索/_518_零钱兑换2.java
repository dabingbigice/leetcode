package com.note.记忆化搜索;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _518_零钱兑换2 {

    public int change(int amount, int[] coins) {
        if (amount == 0) return 1;
        dp=new int[coins.length][amount+1];
        for (int i = 0; i < coins.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        Arrays.fill(dp, -1);

        return dfs(coins, amount, 0, 0);
    }

    int dp[][];

    int dfs(int[] coins, int amount, int cur, int idx) {
        if (cur >= amount) return cur == amount ? 1 : 0;
        if (dp[idx][cur] != -1) return dp[idx][cur];
        int cnt = 0;
        for (int i = idx; i < coins.length; i++) {
            int dfs = dfs(coins, amount, cur + coins[i], i);
            cnt += dfs;
        }
        return dp[idx][cur] = cnt;
    }

    public static void main(String[] args) {
        new _518_零钱兑换2().change(5, new int[]{1, 2, 5});
    }
}
