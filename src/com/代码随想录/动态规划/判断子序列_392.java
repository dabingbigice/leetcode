package com.代码随想录.动态规划;

import java.util.Arrays;

public class 判断子序列_392 {
    public boolean isSubsequence(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) dp[i][i] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = dp[i][j - 1];
            }
        }
        System.out.println(Arrays.toString(dp[s.length()]));
        return dp[s.length()][t.length()] == s.length();
    }
}
