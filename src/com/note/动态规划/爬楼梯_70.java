package com.note.动态规划;

import java.util.Arrays;

public class 爬楼梯_70 {
    int dp[];

    public int climbStairs(int n) {
        if (n==1)return 1;
        dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        System.out.println(Arrays.toString(dp));
        return dp[dp.length - 1];
    }
}
