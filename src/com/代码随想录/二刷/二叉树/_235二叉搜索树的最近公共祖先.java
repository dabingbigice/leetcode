package com.代码随想录.二刷.二叉树;

public class _235二叉搜索树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > q.val && root.val > p.val) return lowestCommonAncestor(root.left, p, q);
        if (root.val < q.val && root.val < p.val) return lowestCommonAncestor(root.right, p, q);
        //当前节点被p和q夹在中间，就是他了
        return root;
    }

    TreeNode res;

    void dfs(TreeNode treeNode, TreeNode p, TreeNode q) {
        //出口，业务，方向

    }
}
