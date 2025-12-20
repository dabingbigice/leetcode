package com.代码随想录.二刷.完全背包;

import java.util.Arrays;

public class _279完全平方数 {
    public int numSquares(int n) {
        //定义dpi为组成完全平方数i的元素数量
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1000000);
        dp[0] = 0;
        for (int i = 1; i * i <= n; i++) {
            int se = i * i;
            for (int j = se; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - se] + 1);
            }
        }
        return dp[n];
    }
}
