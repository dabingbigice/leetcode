package com.代码随想录.动态规划;

import java.util.Arrays;

public class 零钱兑换Ⅱ_518 {
    public int change(int amount, int[] coins) {
        // 创建一维动态规划数组dp，dp[j]表示：凑成总金额j的硬币组合数
        int[] dp = new int[amount + 1];
        // 初始化动态规划数组：处理第一种硬币（coins[0]）的情况
        for (int i = 0; i <= amount; i++) {
            // 如果当前金额i是第一种硬币面值的整数倍，则仅使用该硬币有一种组合方式
            if (i % coins[0] == 0) dp[i] = 1;
            // 注意：对于不能整除的金额，dp[i]保持默认值0，表示无法仅用第一种硬币凑出
        }
        // 动态规划核心过程：遍历剩余的每一种硬币（从第二种开始，索引i=1）
        for (int i = 1; i < coins.length; i++) { // 遍历硬币种类（物品）
            // 完全背包关键：内层循环正序遍历背包容量（金额），从当前硬币面值开始
            // 正序允许同一硬币被多次使用。dp[j]的计算会利用到可能已包含当前硬币的dp[j - coins[i]]
            for (int j = coins[i]; j <= amount; j++) { // 遍历背包容量（金额）
                // 状态转移方程：组合数 = 不选当前硬币的组合数 + 选当前硬币的组合数
                // dp[j] (等号右边): 不选当前硬币，仅使用前i-1种硬币凑出金额j的组合数
                // dp[j - coins[i]]: 选至少一枚当前硬币后，凑出剩余金额(j - coins[i])的组合数
                // 使用i而非i-1，体现了完全背包中物品可重复使用的特性
                dp[j] = dp[j] + dp[j - coins[i]];
            }
        }
        // 返回最终结果：使用所有硬币凑成总金额amount的所有可能组合数
        return dp[amount];
    }

    public int change1(int amount, int[] coins) {
        // 创建二维DP数组：dp[i][j]表示使用前i种硬币凑成总金额j的组合数
        int[][] dp = new int[coins.length][amount + 1];

        // 初始化第一行：只使用第一种硬币时
        for (int i = 0; i <= amount; i++) {
            // 如果金额是第一种硬币的倍数，则有1种组合（全用该硬币），否则为0
            if (i % coins[0] == 0) dp[0][i] = 1;
        }

        // 初始化第一列：金额为0时的组合数
        for (int i = 0; i < coins.length; i++) {
            dp[i][0] = 1; // 金额为0时，只有1种组合：不选任何硬币
        }

        // 打印初始状态（用于调试）
        System.out.println(Arrays.toString(dp[0]));

        // 动态规划核心逻辑
        for (int i = 1; i < coins.length; i++) {    // 遍历硬币种类（从第二种开始）   物品
            for (int j = 1; j <= amount; j++) {     // 遍历目标金额             背包重量
                if (j < coins[i]) {
                    // 当前背包重量小于物品面值，无法使用该硬币：继承前i-1种硬币的组合数
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 完全背包关键：组合数 = 不使用当前硬币 + 使用当前硬币
                    // dp[i-1][j]: 不使用第i种硬币，只使用前i-1种硬币的组合数
                    // dp[i][j-coins[i]]: 使用至少一枚第i种硬币后，剩余金额j-coins[i]的组合数
                    // 使用i而不是i-1，体现完全背包特性：硬币可重复使用[1](@ref)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i]];
                }
            }
        }

        // 打印最终结果（注意：这里应该是dp[coins.length-1]而不是dp[coins.length]）
        System.out.println(Arrays.toString(dp[coins.length - 1])); // 修正数组越界错误

        // 返回使用所有硬币凑成总金额amount的组合数
        return dp[coins.length - 1][amount];
    }
}
