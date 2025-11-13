package com.代码随想录.动态规划;

import java.util.Arrays;

public class 最大子序和_53 {
    /**
     * 求解最大子数组和（Maximum Subarray Problem）的动态规划方法
     * 问题描述：给定一个整数数组，找到连续子数组（至少包含一个元素），使其和最大。
     * 动态规划思路：
     * - 定义dp[i]为以第i个元素结尾的最大子数组和。
     * - 状态转移方程：dp[i] = max(nums[i], dp[i-1] + nums[i])
     * 意为：当前元素要么单独成为一个子数组，要么加入前一个元素结尾的子数组。
     * - 最终结果应为所有dp[i]中的最大值，而非仅dp数组末尾值（当前代码存在错误）。
     * 参考动态规划解法：[2,3,5](@ref)
     */
    public int maxSubArray(int[] nums) {
        // 初始化dp数组，dp[i]表示以nums[i]结尾的最大子数组和
        int[] dp = new int[nums.length];
        // 基准情况：第一个元素无法与更前元素组合，其最大和即为自身
        dp[0] = nums[0];
        // 初始化当前最大值（但此处代码有误：应初始化为dp[0]，而非0。若数组全负数，max将错误记录0）
        int max = 0;  // 错误点：max应初始化为dp[0] = nums[0]，因为子数组不能为空，最大和可能为负数
        // 遍历数组，计算每个位置结尾的最大子数组和
        for (int i = 1; i < nums.length; i++) {
            // 状态转移：选择当前元素单独成组，或与前一个子数组连接（仅当连接能增加和时）
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            // 更新全局最大值
            max = Math.max(dp[i], max);
        }
        // 打印dp数组用于调试（可选）：显示以每个位置结尾的最大和
        System.out.println(Arrays.toString(dp));
        // 返回最终结果（当前代码有误：应返回max，而非dp末尾元素。例如数组[-1, -2]将错误返回-2，实际最大和为-1）
        return dp[nums.length - 1];  // 错误点：应改为 return max;
    }
}
