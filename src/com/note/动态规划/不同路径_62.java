package com.note.动态规划;

import java.util.Arrays;

public class 不同路径_62 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        Arrays.fill(dp[0], 1);
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        System.out.println(Arrays.toString(dp[m - 1]));
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        new 不同路径_62().uniquePaths(3, 7);
    }
}
