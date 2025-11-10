package com.代码随想录.动态规划;

import java.util.Arrays;

public class 整数拆分_343 {
    /**
     * 将正整数 n 拆分为至少两个正整数的和，使得这些整数的乘积最大化。
     * 使用动态规划求解：
     * - dp[i] 表示拆分整数 i 所能获得的最大乘积。
     * - 通过遍历所有可能的拆分点 j，比较直接拆分和进一步拆分的乘积，更新 dp[i]。
     * 时间复杂度：O(n^2)，空间复杂度：O(n)[6,8](@ref)。
     */
    public int integerBreak(int n) {
        // 创建 dp 数组，dp[i] 表示拆分整数 i 可获得的最大乘积[6,7](@ref)
        int[] dp = new int[n + 1];

        // 初始化：拆分 2 的最大乘积为 1（2 = 1 + 1）[6,7](@ref)
        dp[2] = 1;

        // 从 3 开始遍历到 n，计算每个 i 的最大乘积[6](@ref)
        for (int i = 3; i < dp.length; i++) {
            // 对于每个 i，尝试所有可能的拆分点 j（从 1 到 i-1）[6](@ref)
            for (int j = 1; j < i; j++) {
                // 核心递推公式[6,7](@ref)：
                // 1. j * (i - j)：将 i 直接拆分为两个数 j 和 (i - j) 的乘积。
                // 2. j * dp[i - j]：将 i 拆分为 j 和进一步拆分 (i - j) 的乘积（拆分次数 ≥ 3）。
                // 取两者最大值，并与当前 dp[i] 比较，更新为最大值[7](@ref)。
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        // 打印 dp 数组用于调试（可选）
        System.out.println(Arrays.toString(dp));
        // 返回拆分 n 的最大乘积[6](@ref)
        return dp[n];
    }

    public static void main(String[] args) {
        new 整数拆分_343().integerBreak(10);
    }
}
