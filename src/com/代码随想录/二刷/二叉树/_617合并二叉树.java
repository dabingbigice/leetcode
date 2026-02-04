package com.代码随想录.二刷.二叉树;

public class _617合并二叉树 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;

        if (root1 == null || root2 == null) {
            return root1 == null ? root2 : root1;
        }
        dfs(root1, root2);
        return root1;
    }

    void dfs(TreeNode node1, TreeNode node2) {
        //出口，业务，方向
        if (node1 == null || node2 == null) {
            return;
        }
        //业务
        if (node1 != null && node2 != null) {
            node1.val += node2.val;
        }
        if (node1.left == null && node2.left != null) {
            node1.left = node2.left;
            node2.left = null;
        }
        if (node1.right == null && node2.right != null) {
            node1.right = node2.right;
            node2.right = null;
        }
        //方向
        dfs(node1.left, node2.left);
        dfs(node1.right, node2.right);
    }
}
