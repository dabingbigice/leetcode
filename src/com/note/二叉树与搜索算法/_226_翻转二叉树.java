package com.note.二叉树与搜索算法;

public class _226_翻转二叉树 {


    public TreeNode invertTree(TreeNode root) {
        dsf(root);
        return root;
    }

    void dsf(TreeNode root) {
        if (root == null) return;
        //交换
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        dsf(root.left);
        dsf(root.right);
    }
}
