package com.note.动态规划;

import java.util.Arrays;

public class 不同的二叉搜索树_96 {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[dp.length - 1];
    }
}
