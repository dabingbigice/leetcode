package com.note.二叉树与搜索算法;

import java.util.Deque;
import java.util.LinkedList;

public class _110_平衡二叉树 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        dsf(root);
        return flag;
    }

    boolean flag = true;
    //寻找最大值与最小值

    int dsf(TreeNode treeNode) {
        if (treeNode == null) return 0;
        //业务逻辑+递归
        int l = dsf(treeNode.left), r = dsf(treeNode.right);
        if (Math.abs(r - l) > 1) flag = false;
        return Math.max(l, r) + 1;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
//        isBalanced(root1);
//        System.out.println("测试用例1 [3,9,20,null,null,15,7]: " + solution.isBalanced(root1)); // 应输出 true

    }
}
