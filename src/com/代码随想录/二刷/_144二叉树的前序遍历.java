package com.代码随想录.二刷;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _144二叉树的前序遍历 {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> objects = new ArrayList<>();
        proOrder(root, objects);
        return objects;
    }

    public void proOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        proOrder(root.left, list);
        proOrder(root.right, list);
    }
    //right,left
    public List<Integer> preorderTraversal1(TreeNode root) {
        ArrayList<Integer> objects = new ArrayList<>();
        Stack<TreeNode> treeNodes = new Stack<>();
        if (root == null) return objects;
        treeNodes.push(root);
        while (!treeNodes.isEmpty()) {
            TreeNode pop = treeNodes.pop();
            objects.add(pop.val);
            if (pop.right != null) treeNodes.push(pop.right);
            if (pop.left != null) treeNodes.push(pop.left);
        }
        return objects;
    }
}
