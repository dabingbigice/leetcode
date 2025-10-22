package com.note.二叉树与搜索算法;

public class _108_将有序数组转换为二叉搜索树 {
    public TreeNode sortedArrayToBST(int[] nums) {

        return dfs(0, nums.length - 1, nums);
    }

    TreeNode dfs(int l, int r, int[] nums) {
        if (l > r) return null;
        //业务逻辑
        int mid = (l + r) >> 1;
        TreeNode node = new TreeNode(nums[mid]);
        //开始递归构建树
        node.left = dfs(l, mid - 1, nums);
        node.right = dfs(mid + 1, r, nums);
        return node;

    }
}
