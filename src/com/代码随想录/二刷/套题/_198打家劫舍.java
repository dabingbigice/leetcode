package com.代码随想录.二刷.套题;

import java.util.Arrays;

public class _198打家劫舍 {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        if (nums.length < 2) return dp[0];
        dp[1] = Math.max(nums[0], nums[1]); // 两间房，选择金额较大的那间偷窃

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        System.out.println(Arrays.toString(dp));
        return Math.max(dp[nums.length - 1], dp[nums.length - 2]);
    }
}
