package com.代码随想录.二刷;

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
        //划分区间                                              (左子树中序，左子树后序)
        treeNode.left = dfs(inleft, rootindex - 1, postleft, postleft + leftcnt - 1, inorder, postorder);
        treeNode.right = dfs(rootindex + 1, inright, postleft + leftcnt, postright - 1, inorder, postorder);

//        treeNode.left = dfs(inleft, inleft + leftcnt - 1, postleft, postleft + leftcnt - 1, inorder, postorder);
//        treeNode.right = dfs(rootindex + 1, inright, postleft + 1, postright - 1, inorder, postorder);
        //方向
        return treeNode;
    }
}
