package com.代码随想录.二刷.子序列.一个数组;

import java.util.Arrays;

public class _674最长连续递增序列 {
    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) dp[i] = dp[i - 1] + 1;
            else dp[i] = 1;
        }
        System.out.println(Arrays.toString(dp));
        Arrays.sort(dp);
        return dp[dp.length - 1];
    }
}
