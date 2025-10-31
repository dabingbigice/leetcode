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
        //偷和不偷的决定时机是先偷了，知道了结果再去取舍，偷大的那个。
        //所以存在重复运算
        /*
                     A(3)
                   /      \
                B(2)     C(3)
                  \        \
                  D(3)     E(1)
        * dfs(A)
          → sel_A: 需计算 dfs(D) 和 dfs(E)   [第一次计算D、E]
          → unsel_A: 需计算 dfs(B) 和 dfs(C)
          → dfs(B): 内部计算 dfs(D)      [第二次计算D],不偷B偷下一层
          → dfs(C): 内部计算 dfs(E)      [第二次计算E],不偷E偷下一层
        * */

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
