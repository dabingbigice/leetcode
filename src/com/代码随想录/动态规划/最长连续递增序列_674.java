package com.代码随想录.动态规划;

import java.util.Arrays;

public class 最长连续递增序列_674 {
    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) dp[i] = dp[i - 1] + 1;
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
