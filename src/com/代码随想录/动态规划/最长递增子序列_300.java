package com.代码随想录.动态规划;

import java.util.Arrays;

public class 最长递增子序列_300 {
    public int lengthOfLIS(int[] nums) {
        //1.定义dp[i]:以nums[i]结尾的最长递增子序列
        if (nums.length <= 1) return nums.length;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                //nums[i] > nums[j]代表，nums[i] 可以放在 nums[j] 之后，
                // 此时dp[i]=dp[j]+1,在原有j的次数上新增1，表示序列加入nums[i]后可以递增
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        Arrays.sort(dp);
        return dp[dp.length - 1];
    }
}
