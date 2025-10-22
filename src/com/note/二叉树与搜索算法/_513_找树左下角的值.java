package com.note.二叉树与搜索算法;

import java.util.Deque;
import java.util.LinkedList;

public class _513_找树左下角的值 {
    public int findBottomLeftValue(TreeNode root) {
        if (root.left == root.right) return root.val;
        dfs(root, 1);
        return flag;

    }

    void bfs(TreeNode treeNode) {
        Deque<TreeNode> q = new LinkedList<>();
        q.addLast(treeNode);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.pollFirst();
                //最先加进来的是左节点，所以第一次弹出的必定是左节点
                if (i == 0) flag = node.val;
                if (node.left != null) q.addLast(node.left);
                if (node.right != null) q.addLast(node.right);
            }
        }
    }

    int flag = 0;
    int dp = 0;

    void dfs(TreeNode root, int cur) {
        if (root == null) return;
        //业务逻辑
        if (root.left != null && root.left.left == null && root.left.right == null && cur > dp) {
            //找到了当前层的
            dp = cur;
            flag = root.left.val;

        }
        if (root.right != null && root.right.left == null && root.right.right == null && cur > dp) {
            //找到了当前层的
            dp = cur;
            flag = root.right.val;

        }
        //递归
        dfs(root.left, cur + 1);
        dfs(root.right, cur + 1);

    }

    void dfs1(TreeNode root, int cur) {
        if (root == null) return;
        if (root.right == root.left && cur > dp) {
            //记录已经找到了最左侧的节点，防止后续条件满足进入
            dp = cur;
            flag = root.val;
        }
        dfs1(root.left, cur + 1);
        dfs1(root.right, cur + 1);
    }
}
