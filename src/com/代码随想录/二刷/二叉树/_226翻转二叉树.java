package com.代码随想录.二刷.二叉树;

public class _226翻转二叉树 {
    //中左右
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        swap(root);
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public void swap(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}
