package com.代码随想录.二刷.动态规划.子序列.两个数组;

public class _1143最长公共子序列 {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        int res = -1;
        for (int i = 1; i < text1.length() + 1; i++) {
            for (int j = 1; j < text2.length() + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                    //                           (删行,删列)
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                res = Math.max(dp[i][j], res);
            }
        }
        return res;
    }
}
