package com.note.记忆化搜索;

import java.util.Arrays;

public class _62_不同路径 {
    public int uniquePaths(int m, int n) {
        dp=new int[m+1][n+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i],-1);
        }
        return dfs(1,1,m,n);
    }
    int dp[][];
    int dfs(int x, int y, int m, int n) {
        if (x == m && y == n) return 1;
        if (x > m || y > n) return 0;
        if (dp[x][y]!=-1) return dp[x][y];
        return dp[x][y]=dfs(x + 1, y, m, n) + dfs(x, y + 1, m, n);
    }
}
