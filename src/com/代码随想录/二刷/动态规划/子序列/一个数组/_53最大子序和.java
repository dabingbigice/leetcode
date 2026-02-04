package com.代码随想录.二刷.动态规划.子序列.一个数组;

import java.util.Arrays;

public class _53最大子序和 {
    public int maxSubArray(int[] nums) {
        if (nums.length<2) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            res = Math.max(res, dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return res;
    }
}
