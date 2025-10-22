package com.note.二叉树与搜索算法;

import java.util.ArrayList;
import java.util.List;

public class _257_二叉树的所有路径 {
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, new StringBuffer());
        return list;
    }

    ArrayList list = new ArrayList<TreeNode>();

    void dfs(TreeNode root, StringBuffer path) {
        //1.结束条件
        if (root == null) return;

        //2.逻辑处理，业务逻辑
        //拼接
        StringBuffer cur = new StringBuffer(path);
        cur.append(root.val);
        if (root.left == root.right) {
            //叶子节点
            list.add(cur.toString());
            return;
        }
        cur.append("->");
        //递归
        dfs(root.left, cur);
        dfs(root.right, cur);
    }
}
