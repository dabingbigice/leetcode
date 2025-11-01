package com.note.记忆化搜索;

import java.util.Arrays;

public class _63_不同路径2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(obstacleGrid, 0, 0);
    }

    /*
     * 00
     * 01
     * */ int dp[][];

    int dfs(int[][] obs, int x, int y) {
        if (x == obs.length || y == obs[x].length) return 0;
        if (obs[x][y] == 1) return 0;
        if (x == obs.length - 1 && y == obs[x].length - 1 && obs[x][y] != 1) return 1;
        if (dp[x][y] != -1) return dp[x][y];
        return dp[x][y] = dfs(obs, x + 1, y) + dfs(obs, x, y + 1);
    }
}
