package com.代码随想录.二刷.二叉树;

public class _222完全二叉树的节点个数 {
    public int countNodes(TreeNode root) {
        dfs(root);
        return nodeNum;
    }

    int nodeNum = 0;

    //入参,出口,方向
    public void dfs(TreeNode node) {
        //出口
        if (node == null) return;
        //业务.非叶子节点,累加节点数
        if (node != null) nodeNum++;
        //方向
        dfs(node.left);
        dfs(node.right);
    }
}
