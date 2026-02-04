package com.代码随想录.二刷.二叉树;

import java.util.Deque;
import java.util.LinkedList;

public class _111二叉树最小深度 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        dfs(1, root);
        return dp;
    }

    int dp = Integer.MAX_VALUE;

    public void dfs(int val, TreeNode node) {
        //出口，
        if (node == null || val > dp) return;

        //逻辑处理
        if (node.right == null && node.left == null) {
            //叶子节点判断,取小值
            dp = Math.min(dp, val);
            return;
        }
        //方向
        dfs(val + 1, node.left);
        dfs(val + 1, node.right);
    }

    public int bfs(TreeNode node) {
        if (node == null) return 0;
        Deque<TreeNode> objects = new LinkedList<>();
        objects.addLast(node);
        int dp = 0;
        while (!objects.isEmpty()) {
            dp++;
            //固定size,因为队列长度会变化.
            int size = objects.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = objects.pollFirst();
                if (treeNode.left == null && treeNode.right == null) return dp;
                if (treeNode.left != null) objects.addLast(treeNode.left);
                if (treeNode.right != null) objects.addLast(treeNode.right);
            }

        }
        return dp;
    }
}
