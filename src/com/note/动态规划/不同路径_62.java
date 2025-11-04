package com.note.动态规划;

import java.util.Arrays;

public class 不同路径_62 {
    public int uniquePaths(int m, int n) {
        // 创建动态规划数组，dp[i][j]表示从起点(0,0)到达(i,j)的不同路径数量[1,2](@ref)
        int[][] dp = new int[m][n];

        // 初始化第一行：从(0,0)到第一行任何位置(0,j)只有一条路径（一直向右走）[1,6](@ref)
        Arrays.fill(dp[0], 1);

        // 初始化第一列：从(0,0)到第一列任何位置(i,0)只有一条路径（一直向下走）[1,6](@ref)
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        // 动态规划填充其他格子：从(1,1)开始遍历
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                // 状态转移方程：到达(i,j)的路径数 = 从上方(i-1,j)下来的路径数 + 从左方(i,j-1)过来的路径数[1,2,3](@ref)
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        // 打印最后一行dp值（用于调试，可删除）
        System.out.println(Arrays.toString(dp[m - 1]));

        // 返回到达右下角(m-1,n-1)的路径总数
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        new 不同路径_62().uniquePaths(3, 7);
    }
}
