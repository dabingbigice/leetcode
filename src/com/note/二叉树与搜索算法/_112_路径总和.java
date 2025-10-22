package com.note.二叉树与搜索算法;

import java.util.Deque;
import java.util.LinkedList;

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


    boolean dfs1(TreeNode root, int cursum) {
        if (root == null) return false;
        //业务逻辑
        if (root.left == root.right) return cursum == root.val;
        //递归
        return dfs1(root.left, cursum - root.val) || dfs1(root.right, cursum - root.val);
    }

    boolean bfs(TreeNode treeNode, int targetSum) {
        Deque<TreeNode> q = new LinkedList<>();
        if (treeNode != null) q.add(treeNode);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.pollFirst();
                //当寻找到满足条件的时候才停止搜索
                if (node.left == node.right && node.val == targetSum) return true;
                if (node.left != null) {
                    node.left.val += node.val;
                    q.addLast(node.left);
                }
                if (node.right != null) {
                    node.right.val += node.val;
                    q.addLast(node.right);
                }
            }
        }
        return false;
    }
}
