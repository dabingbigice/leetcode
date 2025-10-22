package com.note.二叉树与搜索算法;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _654_最大二叉树 {
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(0, nums.length - 1, nums);
    }

    TreeNode buildTree(int l, int r, int[] nums) {
        if (l > r) return null;
        //找到最大值，划分区间
        int maxIndex = getMax(l, r, nums);
        TreeNode node = new TreeNode(nums[maxIndex]);
        node.left = buildTree(l, maxIndex - 1, nums);
        node.right = buildTree(maxIndex + 1, r, nums);
        return node;
    }

    private int getMax(int l, int r, int[] nums) {
        int index = -1, max = -1;

        for (int i = l; i < r; i++) {
            //记录index
            if (nums[i] > max) {
                index = i;
                max = nums[i];
            }
        }
        return index;
    }

}
