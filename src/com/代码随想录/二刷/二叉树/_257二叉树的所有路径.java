package com.代码随想录.二刷.二叉树;

import java.util.ArrayList;
import java.util.List;

public class _257二叉树的所有路径 {
    public List<String> binaryTreePaths(TreeNode root) {
        //入参，出口，方向
        dfs(root, new StringBuilder());
        return res;
    }

    List<String> res = new ArrayList<String>();

    public void dfs(TreeNode treeNode, StringBuilder path) {
        //出口
        if (treeNode == null) {
            return;
        }
        //业务
        StringBuilder current = new StringBuilder(path);

        current.append(treeNode.val);

        if (treeNode.left == treeNode.right) {
            res.add(current.toString());
            return;
        }
        current.append("->");
        //方向
        dfs(treeNode.left, current);
        dfs(treeNode.right, current);
    }
}
