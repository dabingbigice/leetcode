package com.代码随想录.二刷.动态规划.常规动态规划;

import java.util.Arrays;

public class _70爬楼梯 {

    public int climbStairs(int n) {
        //定义dpi的含义，递推公式，初始化，遍历顺序
        int dp[] = new int[n + 1];
        dp[1] = 1;
        dp[0] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}
