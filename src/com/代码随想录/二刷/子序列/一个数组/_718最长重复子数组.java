package com.代码随想录.二刷.子序列.一个数组;

public class _718最长重复子数组 {
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][1 + nums2.length];
        int res = -1;
        for (int i = 1; i < nums1.length + 1; i++) {
            for (int j = 1; j < nums2.length + 1; j++) {
                if (nums1[i - 1] == nums2[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;
                //若不相等，则默认从为0开始计数
                res = Math.max(dp[i][j], res);
            }
        }
        return res;
    }
}
