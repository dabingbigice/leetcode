package com.代码随想录.动态规划;

import java.util.Arrays;

public class 零钱兑换_322 {

    public int coinChange1(int[] coins, int amount) {
        //1.组合数，先物品后背包。定义dp[j]:装满j的dp[j]个硬币
        //2.初始化,dp[0]=1，      取当前硬币,不取当前硬币。其他值赋值给最大，这样在min的时候可以取到
        //3.递推式:dp[j]=min(1+dp[j-coins[i]],dp[j])
        //4.先物品后背包
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 10010);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {//物品
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j - coins[i]] != 10010) {
                    //加入当前的coins[i]后，还存在方法能够转移状态
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        System.out.println(Arrays.toString(dp));

        return dp[amount] == 10010 ? -1 : dp[amount];
    }


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
