package com.note;

import com.note.二叉树与搜索算法.TreeNode;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Stack;

public class Test {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        stack.push(root);
        TreeNode cur = root;
        while (cur != null || !res.isEmpty()) {
            if (cur != null) {
                //一直向左
                stack.push(cur.)
            }
        }
    }

}
