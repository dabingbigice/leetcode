package com.代码随想录.二刷.动态规划.常规动态规划;

public class _63不同路径II {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //定义dp,递推公式，初始化，遍历顺序
        int dp[][] = new int[obstacleGrid.length][obstacleGrid[0].length];
        //定义 到达i,j有多少种方式
        for (int i = 0; i < dp.length; i++) {
            //初始化为1种方法，碰到石头后续就全为0
            if (obstacleGrid[i][0] != 1)
                dp[i][0] = 1;
            else break;
        }
        for (int i = 0; i < dp[0].length; i++) {
            //初始化为1种方法，碰到石头后续就全为0
            if (obstacleGrid[0][i] != 1)
                dp[0][i] = 1;
            else break;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (obstacleGrid[i][j] != 1)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }
}
