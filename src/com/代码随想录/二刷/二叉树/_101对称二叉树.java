package com.代码随想录.二刷.二叉树;

public class _101对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode left, TreeNode right) {
        //前序遍历
        if (left == null && right != null) return false;
        if (left != null && right == null) return false;
        if (left == null && right == null) return true;
        if (left.val != right.val) return false;//根
        //左右
        return compare(left.left, right.right) && compare(left.right, right.left);
    }
}
