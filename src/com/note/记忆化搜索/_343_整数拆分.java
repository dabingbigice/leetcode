package com.note.记忆化搜索;

public class _343_整数拆分 {
    public int integerBreak(int n) {
        dp = new int[n + 1]; // 初始化记忆化数组，默认值为0
        return dfs(n);
    }

    int dp[]; // 记忆化数组

    int dfs(int n) {
        if (n == 2) return 1; // 基准情况：2只能拆分为1+1，乘积为1
        if (dp[n] != 0) return dp[n]; // 记忆化检查：已计算则直接返回
        int ans = 0;
        // 循环遍历所有可能的拆分点 i（从1到n-2）
        for (int i = 1; i <= n - 2; i++) {
            // 核心计算：比较两种拆分方案的最大值。把当前的n拆为n-i和i。一直拆下去
            ans = Math.max(ans, Math.max(i * (n - i), dfs(n - i) * i));
        }
        return dp[n] = ans; // 存储结果并返回
    }
}
