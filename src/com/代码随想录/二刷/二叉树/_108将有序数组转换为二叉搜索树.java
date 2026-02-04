package com.代码随想录.二刷.二叉树;

public class _108将有序数组转换为二叉搜索树 {
    public TreeNode sortedArrayToBST(int[] nums) {
        //有序数组，取中间值，天然具有平衡性
        return dfs(nums, 0, nums.length - 1);
    }

    TreeNode dfs(int[] nums, int l, int r) {
        if (l > r) return null;
        //取中间，天然平衡
        int mid = (l + r) >> 1;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = dfs(nums, l, mid - 1);
        treeNode.right = dfs(nums, mid + 1, r);
        return treeNode;
    }
}
