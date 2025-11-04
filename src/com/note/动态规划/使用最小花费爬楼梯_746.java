package com.note.动态规划;

import java.util.Arrays;

public class 使用最小花费爬楼梯_746 {
    public int minCostClimbingStairs(int[] cost) {
//        n+1的位置是楼顶
        int[] dp = new int[cost.length + 1];
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(cost[i - 2] + dp[i - 2], cost[i - 1] + dp[i - 1]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
//        new 使用最小花费爬楼梯_746().minCostClimbingStairs(new int[]{10, 15, 20});
        new 使用最小花费爬楼梯_746().minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1});
    }
}
