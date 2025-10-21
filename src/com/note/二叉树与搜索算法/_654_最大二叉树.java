package com.note.二叉树与搜索算法;

import java.util.HashMap;
import java.util.Map;

public class _654_最大二叉树 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {

        return null;
    }

    /**
     * Definition for a binary tree node.
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        // 哈希表，用于快速定位中序遍历中根节点的位置
        private Map<Integer, Integer> inorderIndexMap = new HashMap<>();

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            // 构建哈希映射：值 -> 在中序数组中的索引
            for (int i = 0; i < inorder.length; i++) {
                inorderIndexMap.put(inorder[i], i);
            }
            // 进入递归，初始区间为整个数组
//            return buildSubTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
            return dfs(0, inorder.length - 1, 0, postorder.length - 1, inorder, postorder);
        }

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        TreeNode dfs(int in_left, int in_right, int post_left, int post_right, int[] inorder, int[] postorder) {
            if (in_left > in_right) return null;
            TreeNode node = new TreeNode(postorder[post_right]);
            int in_index = map.get(postorder[post_right]);
            int left_cnt = in_index - in_left;
            node.left = dfs(in_left, in_index - 1, post_left, post_left + left_cnt - 1, inorder, postorder);
            node.right = dfs(in_index + 1, in_right, post_left + left_cnt, post_right - 1, inorder, postorder);
            return node;

        }

        private TreeNode buildSubTree(int[] inorder,
                                      int[] postorder,
                                      int inStart, // 当前子树在中序序列中的起始索引
                                      int inEnd,   // 当前子树在中序序列中的结束索引
                                      int postStart, // 当前子树在后序序列中的起始索引
                                      int postEnd) { // 当前子树在后序序列中的结束索引
            // 递归终止条件：如果区间无效，则当前子树为空
            if (inStart > inEnd || postStart > postEnd) {
                return null;
            }

            // 1. 后序序列的末尾元素是当前子树的根节点
            int rootVal = postorder[postEnd];
            TreeNode root = new TreeNode(rootVal);

            // 2. 在哈希表中找到根节点在中序序列中的位置
            int rootIndexInInorder = inorderIndexMap.get(rootVal);

            // 3. 计算右子树的节点个数（用于划分后序序列）
            int rightSubtreeSize = inEnd - rootIndexInInorder;

            // 4. 递归构建右子树
            //    右子树中序区间: [rootIndexInInorder + 1, inEnd]
            //    右子树后序区间: [postEnd - rightSubtreeSize, postEnd - 1]
            root.right = buildSubTree(inorder, postorder,
                    rootIndexInInorder + 1, inEnd,
                    postEnd - rightSubtreeSize, postEnd - 1);

            // 5. 递归构建左子树
            //    左子树中序区间: [inStart, rootIndexInInorder - 1]
            //    左子树后序区间: [postStart, postEnd - rightSubtreeSize - 1]
            root.left = buildSubTree(inorder, postorder,
                    inStart, rootIndexInInorder - 1,
                    postStart, postEnd - rightSubtreeSize - 1);

            return root;
        }


    }


}
