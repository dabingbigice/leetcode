package com.note.记忆化搜索;


import java.util.HashMap;
import java.util.Map;

public class _337_打家劫舍3 {
    public int rob(TreeNode root) {

        return dfs(root);
    }

    Map<TreeNode, Integer> map = new HashMap<>();

    int dfs(TreeNode root) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);
        //偷当前节点
        int sel = root.val;
        //偷下下层满足条件的节点
        if (root.left != null)
            sel += dfs(root.left.left) + dfs(root.left.right);
        if (root.right != null)
            sel += dfs(root.right.left) + dfs(root.right.right);
        //不偷当前节点，偷下一层节点
        int unsel = dfs(root.right) + dfs(root.left);
        //取最大化收益
        int res = Math.max(unsel, sel);
        map.put(root, res);
        return Math.max(unsel, sel);
    }
}
