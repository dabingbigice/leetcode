package com.note.二叉树与搜索算法;

import java.util.HashMap;
import java.util.Map;

public class _106_从中序与后序遍历序列构造二叉树 {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 构建哈希映射：值 -> 在中序数组中的索引
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(0, inorder.length - 1, 0, postorder.length - 1, inorder, postorder);
    }


    TreeNode dfs(int in_left, int in_right, int post_left, int post_right, int[] inorder, int[] postorder) {
        if (in_left > in_right) return null;
        TreeNode node = new TreeNode(postorder[post_right]);
        int in_index = map.get(postorder[post_right]);
        int left_cnt = in_index - in_left;
        node.left = dfs(in_left, in_index - 1, post_left, post_left + left_cnt - 1, inorder, postorder);
        node.right = dfs(in_index + 1, in_right, post_left + left_cnt, post_right - 1, inorder, postorder);
        return node;

    }
}
