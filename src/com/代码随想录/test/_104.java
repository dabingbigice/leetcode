package com.代码随想录.test;

public class _104 {
    int dp = 0;

    public int maxDepth(TreeNode root) {
        dfs(0, root);
        return dp;
    }

    //入参，出口，方向
    public void dfs(int val, TreeNode node) {
        //出口
        if (node == null) return;
        //处理
        dp = Math.max(val + 1, dp);
        //方向
        dfs(val + 1, node.left);
        dfs(val + 1, node.right);
    }
}
