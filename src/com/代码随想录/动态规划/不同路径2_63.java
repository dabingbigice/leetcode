package com.代码随想录.动态规划;

public class 不同路径2_63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 初始化dp数组，dp[i][j]表示从(0,0)走到(i,j)的不同路径数（障碍物位置用-1标记）
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        boolean flag = false;

        // 初始化第一行：只能从左边向右走
        for (int i = 0; i < dp[0].length; i++) {
            // 如果当前格子不是障碍物且之前未遇到障碍物，路径数为1（唯一路径是直线向右）
            if (obstacleGrid[0][i] != 1 && !flag)
                dp[0][i] = 1;
            // 第一行遇到障碍物时，标记flag为true，表示后续格子均不可达
            if (obstacleGrid[0][i] == 1) flag = true;
        }
        flag = false; // 重置flag用于第一列初始化

        // 初始化第一列：只能从上方向下走
        for (int i = 0; i < dp.length; i++) {
            // 如果当前格子不是障碍物，初始路径数设为1（唯一路径是直线向下）
            if (obstacleGrid[i][0] != 1 && !flag)
                dp[i][0] = 1;
            // 第一列遇到障碍物时，标记flag为true，后续格子不可达
            if (obstacleGrid[i][0] == 1) flag = true;
        }

        // 动态规划填充其余格子：从(1,1)开始遍历
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1]; // 双方可达，路径数相加
                }
            }
        }

        // 输出最后一行dp值用于调试（可选）
        // System.out.println(Arrays.toString(dp[obstacleGrid.length - 1]));
        // 终点是否为-1（障碍物），是则返回0，否则返回路径数
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

    public static void main(String[] args) {
        new 不同路径2_63().uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}});
    }
}
