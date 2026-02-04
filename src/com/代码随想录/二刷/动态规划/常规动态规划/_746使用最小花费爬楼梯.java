package com.代码随想录.二刷.动态规划.常规动态规划;

import java.util.Arrays;

public class _746使用最小花费爬楼梯 {
    //往上条，就花费脚下的体力
    public int minCostClimbingStairs(int[] cost) {
        //定义dpi,递推式，初始化，遍历顺序
        //你可以站在0或1开始爬楼梯，
        //i表示到达第i层要多少花费
        //dp.length-1表示刚好爬出去了的花费
        int dp[] = new int[cost.length + 1];
        //dp[cost.len]不存在，是楼顶
        for (int i = 2; i <= cost.length; i++) {
            //dp[i] = min(之前到这的花费+当前往前走到i的花费)
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[dp.length - 1];
    }
}
