package com.代码随想录.动态规划;

import java.util.Arrays;

public class 最大子序和_53 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            max = Math.max(dp[i], max);
        }
        System.out.println(Arrays.toString(dp));
        return dp[nums.length - 1];
    }
}
