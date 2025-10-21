package com.note.二叉树与搜索算法;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class _404_左叶子之和 {
    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root);
        return count;

    }

    int count = 0;

    void dfs(TreeNode treeNode) {
        if (treeNode == null) return;
        if (treeNode.left != null && treeNode.left.left == null && treeNode.left.right == null) {
            count += treeNode.left.val;
        }
        dfs(treeNode.left);
        dfs(treeNode.right);
    }
}
