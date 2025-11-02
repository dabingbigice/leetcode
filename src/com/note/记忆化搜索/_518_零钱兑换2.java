package com.note.记忆化搜索;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _518_零钱兑换2 {

    public int change(int amount, int[] coins) {
        if (amount == 0) return 1; // 基准情况：凑出金额0只有1种方法（什么都不选）
        dp = new int[coins.length][amount + 1]; // 初始化记忆化数组
        for (int i = 0; i < coins.length; i++) {
            Arrays.fill(dp[i], -1); // 正确：将每一行初始化为-1，表示未计算
        }
        return dfs(coins, amount, 0, 0); // 开始DFS，初始状态：从第0个硬币选，当前金额0
    }

    int dp[][]; // 记忆化数组

    int dfs(int[] coins, int amount, int cur, int idx) {
        // 1. 递归终止条件
        if (cur >= amount) return cur == amount ? 1 : 0;
        // 2. 记忆化检查：如果当前状态已计算过，直接返回结果
        if (dp[idx][cur] != -1) return dp[idx][cur];

        int cnt = 0;
        // 3. 递归探索：尝试从当前索引idx开始选择每一枚硬币
        for (int i = idx; i < coins.length; i++) {
            // 选择硬币coins[i]，更新当前金额，并递归计算新状态
            cnt += dfs(coins, amount, cur + coins[i], i);
        }
        // 4. 存储结果到记忆化数组并返回
        return dp[idx][cur] = cnt;
    }

    public static void main(String[] args) {
        new _518_零钱兑换2().change(5, new int[]{1, 2, 5});
    }
}
