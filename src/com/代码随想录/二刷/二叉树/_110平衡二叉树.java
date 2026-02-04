package com.代码随想录.二刷.二叉树;

public class _110平衡二叉树 {
    public boolean isBalanced(TreeNode root) {
        //入参，出口，方向
        dfs(root);
        return flag;
    }

    boolean flag = true;

    public int dfs(TreeNode root) {
        //先想到递归/层次到叶子节点是什么样子
        //然后开始决定出口返回值
        //最后非叶子节点的返回值
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (Math.abs(left - right) > 1) flag = false;
        return Math.max(left, right) + 1;
    }
}
