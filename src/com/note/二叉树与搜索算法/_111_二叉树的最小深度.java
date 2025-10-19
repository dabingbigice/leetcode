package com.note.二叉树与搜索算法;

import java.util.Deque;
import java.util.LinkedList;

public class _111_二叉树的最小深度 {
    int dp = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        dfs(root, 1);
        return dp;
    }

    private void dfs(TreeNode root, int crdp) {
        if (root == null) return;
        //处理深度
        if (root.right == root.left) {
            dp = Math.min(dp, crdp);
            return;
        }
        dfs(root.right, crdp + 1);
        dfs(root.left, crdp + 1);

    }

    int bfs(TreeNode root) {
        int dp = 0;
        if (root == null) return dp;
        Deque<TreeNode> q = new LinkedList<>();
        q.addLast(root);
        while (!q.isEmpty()) {
            int size = q.size();
            dp++;
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = q.pollFirst();
                if (treeNode.right == treeNode.left) return dp;
                if (treeNode.right != null) q.addLast(treeNode.right);
                if (treeNode.left != null) q.addLast(treeNode.left);
            }
        }
        return dp;
    }
}
