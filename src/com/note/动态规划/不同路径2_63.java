package com.note.动态规划;

import java.util.Arrays;

public class 不同路径2_63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        boolean flag = false;
        for (int i = 0; i < dp[0].length; i++) {
            if (obstacleGrid[0][i] != 1 && !flag)
                dp[0][i] = 1;

            //第一行存在一个1，此后的路走不通
            if (obstacleGrid[0][i] == 1) flag = true;
            if (flag) dp[0][i] = 0;
        }
        flag = false;

        for (int i = 0; i < dp.length; i++) {
            if (obstacleGrid[i][0] != 1)
                dp[i][0] = 1;

            //第一列存在一个1，此后的路走不通
            if (obstacleGrid[i][0] == 1) flag = true;
            if (flag) dp[i][0] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (obstacleGrid[i][j] != 1) {
                    if (dp[i - 1][j] == -1 && dp[i][j - 1] != -1)
                        dp[i][j] = dp[i][j - 1];

                    if (dp[i - 1][j] != -1 && dp[i][j - 1] == -1)
                        dp[i][j] = dp[i - 1][j];

                    if (dp[i - 1][j] != -1 && dp[i][j - 1] != -1)
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

                } else {
                    dp[i][j] = -1;
                }
            }
        }
        System.out.println(Arrays.toString(dp[obstacleGrid.length - 1]));
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == -1 ? 0 : dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];

    }

    public static void main(String[] args) {
        new 不同路径2_63().uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}});
    }
}
