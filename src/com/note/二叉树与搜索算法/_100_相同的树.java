package com.note.二叉树与搜索算法;

import java.util.Deque;
import java.util.LinkedList;

public class _100_相同的树 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (q == null && p != null) {
            return false;
        }
        if (p == null && q != null) {
            return false;
        }

        return bfs(p, q);
    }

    boolean bfs(TreeNode p, TreeNode q) {
        Deque<TreeNode> q_p = new LinkedList<>();
        Deque<TreeNode> q_q = new LinkedList<>();
        q_q.add(p);
        q_p.add(q);
        while (!q_p.isEmpty() && !q_q.isEmpty()) {
            int qsize = q_q.size();
            int psize = q_p.size();
            if (qsize != psize) return false;
            for (int i = 0; i < qsize; i++) {
                TreeNode pnode = q_p.pollFirst();
                TreeNode qnode = q_q.pollFirst();
                if (pnode == qnode) continue;

                if (pnode == null && qnode != null) return false;
                if (pnode != null && qnode == null) return false;
                if (pnode.val != qnode.val) return false;
                q_p.addLast(pnode.left);
                q_p.addLast(pnode.right);
                q_q.addLast(qnode.left);
                q_q.addLast(qnode.right);
            }
        }
        return true;
    }

    boolean dfs(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null) return node1 == node2;
        if (node1.val != node2.val) return false;

        return dfs(node1.right, node2.left)&&dfs(node1.left, node2.right);
    }
}
