package com.代码随想录.二刷.二叉树;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class _145二叉树的后序遍历 {
    //栈的元素要反正放入
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> objects = new ArrayList<>();
        Stack<TreeNode> treeNodes = new Stack<>();
        if (root == null) return objects;
        treeNodes.push(root);
        while (!treeNodes.isEmpty()) {
            TreeNode pop = treeNodes.pop();
            objects.add(pop.val);
            if (pop.left != null) treeNodes.push(pop.left);
            if (pop.right != null) treeNodes.push(pop.right);
        }
        Collections.reverse(objects);
        return objects;

    }
}


