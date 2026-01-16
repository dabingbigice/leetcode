package com.代码随想录.二刷;

public class _100相同的树 {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        return dfs(p, q);
    }

    //入参，出口，方向
    public boolean dfs(TreeNode node1, TreeNode node2) {
        if (node2 == null || node1 == null) return node2 == node1;
        return node2.val == node1.val && dfs(node1.left, node2.left) && dfs(node1.right, node2.right);
    }
}
