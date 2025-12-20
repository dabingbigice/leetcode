package com.代码随想录.二刷.子序列.两个数组;

public class _583两个字符串的删除操作 {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        //删除为空串
        for (int i = 1; i <= word2.length(); i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                //相同，不删，延用之前的
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                    //删word1,word2,都删,取小者
//                else dp[i][j] = Math.min(dp[i - 1][j - 1] + 2, Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                else dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
