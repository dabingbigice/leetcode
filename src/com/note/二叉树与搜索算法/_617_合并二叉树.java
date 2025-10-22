package com.note.二叉树与搜索算法;

import java.util.Deque;
import java.util.LinkedList;

public class _617_合并二叉树 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        return null;
    }

    void bfs(TreeNode root1, TreeNode root2) {
        Deque<TreeNode> q1 = new LinkedList<>();
        Deque<TreeNode> q2 = new LinkedList<>();
        q1.addFirst(root1);
        q2.addFirst(root2);

    }

    TreeNode dfs(TreeNode root1, TreeNode root2) {
        if (root1 == root2) return null;
        //其中一个不为Null,开始构造节点。
        int v1 = root1 == null ? 0 : root1.val;
        int v2 = root2 == null ? 0 : root2.val;
        TreeNode node = new TreeNode(v1 + v2);
        //从递归最底层开始向上构造
        node.left = dfs(root1 == null ? null : root1.left, root2 == null ? null : root2.left);
        node.right = dfs(root1 == null ? null : root1.right, root2 == null ? null : root2.right);
        return node;
    }
}
