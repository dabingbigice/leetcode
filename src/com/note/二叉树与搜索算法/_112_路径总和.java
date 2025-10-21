package com.note.二叉树与搜索算法;

public class _112_路径总和 {
    boolean flag = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {

        dfs(root, targetSum, 0);
        return flag;
    }

    void dfs(TreeNode treeNode, int targetSum, int sumNumber) {
        if (treeNode == null) return;
        if (treeNode.left == treeNode.right) {
            //叶子节点
            sumNumber += treeNode.val;
            if (sumNumber == targetSum) flag = true;
            return;
        }
        sumNumber += treeNode.val;
        dfs(treeNode.left, targetSum, sumNumber);
        dfs(treeNode.right, targetSum, sumNumber);
    }
}
