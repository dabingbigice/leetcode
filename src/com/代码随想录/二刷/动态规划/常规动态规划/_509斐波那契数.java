package com.代码随想录.二刷.动态规划.常规动态规划;

import java.util.Arrays;

public class _509斐波那契数 {


    public int fib(int n) {
        //定义下标，递推公式，初始化，遍历顺序
        int dp[] = new int[n + 1];
        if (n==0) return 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}
