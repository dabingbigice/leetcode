package com.note.记忆化搜索;

import java.util.Arrays;

public class _64_最小路径和 {
    public int minPathSum(int[][] grid) {
        dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        int res = dfs(grid, 0, 0);
        return res;

    }

    int dp[][];

    /*
    1,2,3
    4,5,6
    * */
    int dfs(int[][] grid, int downIndex, int rightIndex) {
        //到边界了
        if (downIndex == grid.length - 1 && rightIndex == grid[downIndex].length - 1)
            return grid[downIndex][rightIndex];
        if (downIndex == grid.length || rightIndex == grid[downIndex].length)
            return Integer.MAX_VALUE;
        if (dp[downIndex][rightIndex] != -1) return dp[downIndex][rightIndex];
        return dp[downIndex][rightIndex] = Math.min(dfs(grid, downIndex + 1, rightIndex), dfs(grid, downIndex, rightIndex + 1)) + grid[downIndex][rightIndex];
    }

    public static void main(String[] args) {

        new _64_最小路径和().minPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}});
    }
}
