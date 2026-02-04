package com.代码随想录.二刷.动态规划.子序列.两个数组;

import java.util.Arrays;

public class _392判断子序列 {
    public boolean isSubsequence(String s, String t) {
        if (s.equals("")) return true;
        boolean[][] dp = new boolean[s.length() + 1][t.length() + 1];
        Arrays.fill(dp[0], true);
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = dp[i][j - 1];
            }
        }
        for (int i = 0; i < s.length(); i++) {
            System.out.println(Arrays.toString(dp[i]));

        }
        return dp[s.length()][t.length()];
    }
}
