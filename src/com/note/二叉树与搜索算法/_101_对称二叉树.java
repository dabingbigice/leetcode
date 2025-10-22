package com.note.二叉树与搜索算法;

public class _101_对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        //转过来进行一次层次遍历
        return dfs(root.left, root.right);
    }

    boolean dfs(TreeNode l, TreeNode r) {
        //业务逻辑
        if (l == null || r == null) return l == null && r == null;
        //递归
        return l.val == r.val && dfs(l.left, r.right) && dfs(l.right, r.left);
    }


}
