package com.代码随想录.二刷.动态规划.子序列.一个数组;

import java.util.Arrays;

public class _300最长递增子序列 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length < 2) return 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                //依次取以i结尾的切片，更新切片里面的长递增子序列长度。
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        Arrays.sort(dp);
        System.out.println(Arrays.toString(dp));
        return dp[dp.length - 1];
    }
}
