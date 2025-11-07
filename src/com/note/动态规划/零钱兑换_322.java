package com.note.动态规划;

import java.util.Arrays;

public class 零钱兑换_322 {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // 初始化dp数组，防止数值被覆盖，取最大值
        for (int j = 0; j < dp.length; j++) {
            dp[j] = Integer.MAX_VALUE;
        }
        dp[0] = 0; // 基础情况

        // 动态规划过程
        for (int i = 0; i < coins.length; i++) {         // 遍历物品（硬币）
            for (int j = coins[i]; j <= amount; j++) {  // 遍历背包容量（金额），正序以实现完全背包
                // 确保j - coins[i]是有效状态（即可达状态）,
                // 没装满的都是最大值，取不到
                if (dp[j - coins[i]] != Integer.MAX_VALUE) {
                    // 状态转移：核心逻辑，使用当前硬币coins[i],
                    dp[j] = Math.min(dp[j], 1 + dp[j - coins[i]]); // 修正了这里，使用coins[i]
                }
            }
        }
        // 输出dp数组用于调试（可选）
        System.out.println(Arrays.toString(dp));
        // 返回结果
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
    public static void main(String[] args) {
        new 零钱兑换_322().coinChange(new int[]{1, 2, 5}, 11);
    }
}
