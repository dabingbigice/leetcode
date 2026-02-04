package com.代码随想录.二刷.动态规划.子序列.两个数组;

public class _1035不相交的线 {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int res = -1;
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;
                    //如果不相等，考虑删除一个元素。未知删除哪一个
                    //                           (删行,删列)
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}
