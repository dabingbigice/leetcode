package com.代码随想录.二刷.二叉树;

public class _513找树左下角的值 {

    public int findBottomLeftValue(TreeNode root) {
        if (root.left==root.right)return root.val;
        dfs(root, 1);
        return val;
    }

    int dp = 0;
    int val = 0;

    public void dfs(TreeNode treeNode, int cur) {
        //找最左边的叶子节点
        //出口
        if (treeNode == null) return;
        //业务
        if (treeNode != null && treeNode.left== null && treeNode.right == null) {
            //左叶子节点
            if (cur > dp) {
                val = treeNode.left.val;
                dp = cur;
            }
        }
        //方向
        dfs(treeNode.left, cur + 1);
        dfs(treeNode.right, cur + 1);
    }
}
