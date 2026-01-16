package com.代码随想录.二刷;

public class _404左叶子之和 {
    public int sumOfLeftLeaves(TreeNode root) {
        //入参，出口，方向
        dfs(root);
        return rse;
    }

    int rse = 0;

    public void dfs(TreeNode treeNode) {
        if (treeNode == null) {
            //出口
            return;
        }
        //业务
        if (treeNode.left != null && treeNode.left.left == null && treeNode.left.right == null) {
            //左叶子
            rse += treeNode.left.val;
        }
        //方向
        dfs(treeNode.left);
        dfs(treeNode.right);
    }
}
