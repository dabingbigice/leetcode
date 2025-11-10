package com.代码随想录.动态规划;

import java.util.Arrays;

public class 使用最小花费爬楼梯_746 {
    //第一步不消耗,最后一步消耗
    public int minCostClimbingStairs(int[] cost) {
        // 创建动态规划数组，dp[i]表示到达第i个台阶（位置）的最小花费
        // 注意：楼顶是第cost.length个位置，所以dp数组长度为cost.length + 1
        int[] dp = new int[cost.length + 1];

        // 初始化：dp[0]和dp[1]默认为0（因为Java会默认初始化int数组为0）
        // 这符合题意：可以选择从下标0或1的台阶开始，初始位置不需要花费

        // 动态规划：从第2个位置开始计算到达每个位置的最小花费
        for (int i = 2; i <= cost.length; i++) {
            // 状态转移方程：到达位置i有两种方式：
            // 1. 从i-2位置爬2步上来，花费 = 到达i-2的最小花费(dp[i-2]) + 从i-2台阶爬起的费用(cost[i-2])
            // 2. 从i-1位置爬1步上来，花费 = 到达i-1的最小花费(dp[i-1]) + 从i-1台阶爬起的费用(cost[i-1])
            // 取两种方式中的较小值作为到达位置i的最小花费
            dp[i] = Math.min(cost[i - 2] + dp[i - 2], cost[i - 1] + dp[i - 1]);
        }

        // 打印dp数组用于调试（可以看到到达每个位置的最小花费）
        System.out.println(Arrays.toString(dp));

        // 返回到达楼顶（最后一个位置，即dp[cost.length]）的最小花费
        return dp[dp.length - 1];
    }

    //第一步消耗，最后一步不消耗
    public int minCostClimbingStairs1(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        //最后一步已经支付，故dp[dp.length - 1], dp[dp.length - 2]都可以到达终点
        //所以取小值
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(cost[i] + dp[i - 2], cost[i] + dp[i - 1]);
        }
        // System.out.println(Arrays.toString(dp));
        return Math.min(dp[dp.length - 1], dp[dp.length - 2]);
    }

    public static void main(String[] args) {
//        new 使用最小花费爬楼梯_746().minCostClimbingStairs(new int[]{10, 15, 20});
        new 使用最小花费爬楼梯_746().minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1});
    }
}
