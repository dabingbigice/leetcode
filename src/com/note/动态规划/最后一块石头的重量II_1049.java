package com.note.动态规划;

import java.util.Arrays;

public class 最后一块石头的重量II_1049 {
    public int lastStoneWeightII(int[] stones) {
        // 计算所有石头的总重量
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        // 计算目标值：总重量的一半（使用位运算右移1位等价于除以2）
        // 这个问题的本质是将石头分成两堆，使两堆的重量差最小
        int target = sum >> 1;
        // 创建动态规划数组，dp[j]表示容量为j的背包能装的最大石头重量
        // 这实际上是一个0-1背包问题的变种
        int[] dp = new int[target + 1];
        // 动态规划过程：遍历每个石头
        for (int i = 0; i < stones.length; i++) {
            // 内层循环：从目标容量倒序遍历到当前石头的重量
            // 倒序遍历确保每个石头只被使用一次（0-1背包特性）
            for (int j = target; j >= stones[i]; j--) {
                // 状态转移方程：决定是否将当前石头放入背包
                // 选择1：不放入当前石头，价值为dp[j]（之前已达到的最大值）
                // 选择2：放入当前石头，价值为stones[i] + dp[j - stones[i]]
                // 取两者中的较大值，更新dp数组
                dp[j] = Math.max(dp[j], stones[i] + dp[j - stones[i]]);
            }
        }
        // 打印dp数组用于调试（可以看到每个容量能装的最大重量）
        System.out.println(Arrays.toString(dp));
        // 返回最终结果：总重量减去两倍的最大子集和
        // 这表示两堆石头的重量差：(sum - dp[target]) - dp[target] = sum - 2*dp[target]
        return sum - dp[target] * 2;
    }
}
