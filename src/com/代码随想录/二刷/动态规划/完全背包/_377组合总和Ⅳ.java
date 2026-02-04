package com.代码随想录.二刷.动态规划.完全背包;

public class _377组合总和Ⅳ {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
            for (int j = 1; j <= target; j++) {
                for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= j)
                    dp[j] = dp[j] + dp[j - nums[i]];
            }

        }
        return dp[target];
    }
}
