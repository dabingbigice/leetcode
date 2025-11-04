package com.note.动态规划;

import java.util.Arrays;

public class 爬楼梯_70 {
    int dp[];

    public int climbStairs(int n) {
        // 处理基础情况：如果只有1阶楼梯，只有1种方式（爬1阶）
        if (n == 1) return 1;

        // 创建动态规划数组，dp[i]表示爬到第i阶楼梯的不同方法总数
        // 数组长度为n+1，以便索引对应楼梯阶数（从0到n，通常忽略0或视情况初始化）
        dp = new int[n + 1];

        // 初始化基础情况：
        dp[1] = 1; // 爬到第1阶只有1种方法：爬1阶
        dp[2] = 2; // 爬到第2阶有2种方法：每次爬1阶（两次），或一次爬2阶

        // 动态规划填充过程：从第3阶开始迭代计算到第n阶
        for (int i = 3; i <= n; i++) {
            // 状态转移方程：到达第i阶的方法数 = 从第i-2阶爬2阶上来的方法数 + 从第i-1阶爬1阶上来的方法数
            // 这利用了斐波那契数列原理（F(n) = F(n-1) + F(n-2)）[1,3,8](@ref)
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        // 打印dp数组（用于调试或观察中间结果，可删除）
        System.out.println(Arrays.toString(dp));

        // 返回到达第n阶（楼顶）的总方法数，即dp数组最后一个元素
        return dp[dp.length - 1];
    }
}
