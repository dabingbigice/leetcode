package com.代码随想录.test;

public class _101 {
    public boolean isSymmetric(TreeNode root) {
        return compare(root.left, root.right);
    }
    //若两个节点都为null，则表明对称，两个节点不为null，此时再对比值，若不同则为false
    //参数入参
    private boolean compare(TreeNode left, TreeNode right) {
        //出口
        if (left == null && right != null) return false;
        if (left != null && right == null) return false;
        if (left == right) return true;
        if (left.val != right.val) return false;
        //方向
        return compare(left.left, right.right) && compare(left.right, right.left);
    }
}
