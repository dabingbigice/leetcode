package com.代码随想录.二刷.动态规划.套题;

import java.util.Arrays;

public class _198打家劫舍2 {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        return Math.max(robTemp(Arrays.copyOfRange(nums, 0, nums.length - 1)), robTemp(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    public int robTemp(int[] nums) {
        int[] dp = new int[nums.length];
        dp[1] = Math.max(nums[0], nums[1]);
        dp[0] = nums[0];
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return Math.max(dp[dp.length - 1], dp[dp.length - 2]);
    }
}
