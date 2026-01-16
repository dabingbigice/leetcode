package com.代码随想录.二刷;

import java.util.ArrayList;
import java.util.List;

public class _112路径总和 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;

        if (root == null) return true;
        return dfs(root, 0);
    }

    int targetSum;

    public boolean dfs(TreeNode treeNode, int sum) {
        //出口
        if (treeNode == null) return true;
        //业务
        if (treeNode.left == null && treeNode.right == null) {
            sum += treeNode.val;
            if (sum == this.targetSum) return true;
            else return false;
        }
        return dfs(treeNode.left, sum + treeNode.val) || dfs(treeNode.right, sum + treeNode.val);
        //方向
    }

    List<Integer> res = new ArrayList<>();
    int flag = 0;

    public void dfs1(TreeNode treeNode, int sum) {
        //出口
        if (treeNode == null) return;
        //业务
        if (treeNode.left == null && treeNode.right == null) {
            sum += treeNode.val;
            if (sum == targetSum) flag = 1;
        }
        dfs1(treeNode.left, sum + treeNode.val);
        dfs1(treeNode.right, sum + treeNode.val);
        //方向
    }
}
