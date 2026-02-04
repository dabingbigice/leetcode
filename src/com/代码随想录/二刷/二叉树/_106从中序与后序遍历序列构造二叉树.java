package com.代码随想录.二刷.二叉树;

import java.util.HashMap;

public class _106从中序与后序遍历序列构造二叉树 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(0, inorder.length - 1, 0, postorder.length - 1, inorder, postorder);
    }

    HashMap map = new HashMap<Integer, Integer>();

    public TreeNode dfs(int inleft, int inright, int postleft, int postright, int[] inorder, int[] postorder) {
        //出口
        if (inleft > inright) return null;
        //业务
        //拿到根节点
        Integer rootindex = (Integer) map.get(postorder[postright]);
        //构建根节点
        TreeNode treeNode = new TreeNode(postorder[postright]);
        //根节点索引-left节点索引=左区间
        int leftcnt = rootindex - inleft;
//        左子树在后序序列中的起始位置：
//        后序序列的顺序是左子树优先，
//        因此左子树部分一定从当前后序区间的起始位置 postleft开始 。
//        左子树在后序序列中的结束位置：由于左子树包含 leftcnt个节点，后序序列中左子树的结束索引就是 postleft + leftcnt - 1
//       （索引从 postleft开始，连续 leftcnt个元素）。
//        例如，如果 leftcnt = 3，左子树后序区间为 [postleft, postleft + 2]，对应3个节点。

        //划分区间                                              (左子树中序，左子树后序)
        treeNode.left = dfs(inleft, rootindex - 1, postleft, postleft + leftcnt - 1, inorder, postorder);
        treeNode.right = dfs(rootindex + 1, inright, postleft + leftcnt, postright - 1, inorder, postorder);

//        treeNode.left = dfs(inleft, inleft + leftcnt - 1, postleft, postleft + leftcnt - 1, inorder, postorder);
//        treeNode.right = dfs(rootindex + 1, inright, postleft + 1, postright - 1, inorder, postorder);
        //方向
        return treeNode;
    }
}
