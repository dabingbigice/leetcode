package com.代码随想录.二刷;

import java.util.Arrays;

public class _96不同的二叉搜索树 {
    public int numTrees(int n) {
        //定义dpi,初始化，遍历顺序，递推公式
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                //简单来说，dp[j-1]代表的是，当您选定一个j根节点后，其左子树的所有可能结构数量。
                //简单来说，* dp[i - j]代表的是，当您选定一个j根节点后，其右子树的所有可能结构数量。
                dp[i] += dp[j - 1] * dp[i - j];
                //    左子树的节点个数*右子树的节点个数
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}
