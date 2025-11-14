package com.代码随想录.动态规划;

import java.util.Arrays;

public class 不同的子序列_115 {
    public int numDistinct(String s, String t) {
        //1.以i-1结尾的s中有以j-1结尾的t的个数
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        //2.初始化默认
        for (int i = 0; i < s.length() + 1; i++) {
            dp[i][0] = 1;
        }
        //递推式
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                else dp[i][j] = dp[i - 1][j];
            }
        }
        System.out.println(Arrays.toString(dp[s.length()]));
        return dp[s.length()][t.length()];
    }
}
