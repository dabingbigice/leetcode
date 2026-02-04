package com.代码随想录.二刷.二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _94二叉树的中序遍历 {

    //left到底，left==null，然后切换为right
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root; // 当前遍历节点

        while (curr != null || !stack.isEmpty()) {
            //curr == null 表示，左边已经到头了，所以要弹出这个节点
            // 深入左子树：将当前节点及其左子树全部入栈
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;//一直向左，只要左不空
            }
            // 回溯并访问：没有左子树可深入时，出栈访问，再转向右子树
            else {
                //左空了，就输出一个元素，然后继续走右节点
                TreeNode node = stack.pop();
                result.add(node.val); // 访问节点
                curr = node.right; // 转向右子树
            }
        }
        return result;
    }

    public List<Integer> inorderTraversal1(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root.left; // 当前遍历节点
        stack.push(root);
        //当 curr==null时，意味着我们已经沿着某条路径走到了最左端。
        //此时，循环不能结束，因为最重要的“访问节点”和“转向右子树”步骤还没进行。
        while (curr != null || !stack.isEmpty()) {
            //curr == null 表示，左边已经到头了，所以要弹出这个节点
            //一路向左
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode pop = stack.pop();
                result.add(pop.val);
                //改为右节点
                curr = pop.right;
            }
        }
        return result;
    }

    public void order(TreeNode node, List<Integer> list) {
        if (node.left != null) order(node.left, list);
        list.add(node.val);
        if (node.right != null) order(node.right, list);
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> objects = new ArrayList<>();
        if (root == null) return objects;
        Stack<TreeNode> treeNodes = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !treeNodes.isEmpty()) {
            if (curr != null) {
                //还能向左
                treeNodes.push(curr);
                curr = curr.left;
            } else {
                //到头了，没有添加新节点
                TreeNode node = treeNodes.pop();
                objects.add(node.val);
                //遍历右节点
                curr = node.right;
            }
        }
        return objects;
    }


    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> objects = new ArrayList<>();
        if (root == null) return objects;
        Stack<TreeNode> treeNodes = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !treeNodes.isEmpty()) {
            if (curr != null) {
                //往左
                treeNodes.push(curr);
                curr = curr.left;
            } else {
                //吐出来，往右
                TreeNode node = treeNodes.pop();
                objects.add(node.val);
                curr = node.right;
            }
        }
        return objects;
    }
}
