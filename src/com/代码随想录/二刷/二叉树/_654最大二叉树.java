package com.代码随想录.二刷.二叉树;

public class _654最大二叉树 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(0, nums.length - 1, nums);
    }

    TreeNode buildTree(int l, int r, int[] nums) {
        if (l > r) return null;
        int index = getIndex(nums, l, r);
        TreeNode treeNode = new TreeNode(nums[index]);
        //二分
        treeNode.left = buildTree(l, index - 1, nums);
        treeNode.right = buildTree(index + 1, r, nums);
        return treeNode;
    }

    int getIndex(int[] nums, int l, int r) {
        int max = -1;
        int idx = -1;
        for (int i = l; i <= r; i++) {
            if (nums[i] > max) idx = i;
            max = Math.max(max, nums[i]);
        }
        return idx;
    }
}
