package com.note.动态规划;

import java.util.Arrays;

public class 完全平方数_279 {
    public int numSquares(int n) {
        // 定义dp数组，dp[j]表示组成数字j所需的最少完全平方数个数[1](@ref)
        int[] dp = new int[n + 1];
        // 初始化dp数组，填充一个较大的值（10086）表示初始状态不可达[6](@ref)
        Arrays.fill(dp, 10086);
        dp[0] = 0; // 基础情况：组成0需要0个平方数

        // 外层循环：遍历所有可能的完全平方数（物品）[1](@ref)
        for (int i = 1; i * i <= n; i++) {
            int square = i * i; // 当前平方数（物品重量）
            // 内层循环：遍历背包容量j，从当前平方数开始到n[1](@ref)
            for (int j = square; j <= n; j++) {
                //简单来说，dp[j - square] + 1是解决“完全平方数”这类问题的钥匙。
                //减去当前这个平方数之后的值需要多少个平方数组成，
                // 再+1表示组成的平方数总数。
                // 状态转移方程：选择当前平方数（dp[j-square] + 1）或不选（dp[j]），取最小值[5](@ref)
                dp[j] = Math.min(dp[j], dp[j - square] + 1);
            }
        }

        // 输出dp数组用于调试（可选，生产环境可移除）[6](@ref)
        System.out.println(Arrays.toString(dp));
        return dp[n]; // 返回组成n的最少平方数个数
    }

    public static void main(String[] args) {
        new 完全平方数_279().numSquares(13);
    }
}
