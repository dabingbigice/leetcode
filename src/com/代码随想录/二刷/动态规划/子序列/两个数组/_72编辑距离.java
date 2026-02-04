package com.代码随想录.二刷.动态规划.子序列.两个数组;

public class _72编辑距离 {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1; i <= word2.length(); i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                //相等
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                    //操作                       (替换,删,插入)
                else dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i - 1][j], dp[i][j - 1]) + 1);
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
