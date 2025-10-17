package com.note.二叉树与搜索算法;

import java.util.Deque;
import java.util.LinkedList;

public class _104_二叉树的最大深度 {
    public int maxDepth(TreeNode root) {
        return bfs(root);
    }


    int bfs(TreeNode root) {
        Deque<TreeNode> q = new LinkedList<>();
        q.addLast(root);
        int ds = 0;
        while (!q.isEmpty()) {
            //当前层的元素个数
            int size = q.size();
            ds++;
            //全部取出
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = q.pollFirst();
                if (treeNode != null) {
                    q.addLast(treeNode.left);
                    q.addLast(treeNode.right);
                }
            }
        }
        return ds;
    }

    int dp = 0;

    void dfs(TreeNode root, int currentdp) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            dp = Math.max(currentdp, dp);
        }
        dfs(root.right, currentdp + 1);
        dfs(root.left, currentdp + 1);
    }
}
