package com.note.二叉树与搜索算法;

import java.util.Deque;
import java.util.LinkedList;

public class _226_翻转二叉树 {


    public TreeNode invertTree(TreeNode root) {
        dsf(root);
        return root;
    }

    void dsf(TreeNode root) {
        if (root == null) return;
        //交换
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        dsf(root.left);
        dsf(root.right);
    }

    void bsf(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.pollFirst();
                TreeNode temp = treeNode.left;
                treeNode.left = treeNode.right;
                treeNode.right = temp;
                if (treeNode.left != null) {
                    queue.addLast(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.addLast(treeNode.right);
                }
            }

        }
    }
}
