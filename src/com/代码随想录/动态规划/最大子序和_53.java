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
        // 边界情况：如果数组长度小于2，直接返回唯一的元素
        if (nums.length<2) return nums[0];
        // 创建dp数组，dp[i]表示以nums[i]结尾的最大子数组和
        int[] dp = new int[nums.length];
        // 初始化：以第一个元素结尾的最大子数组和就是它自己
        dp[0] = nums[0];
        // 初始化结果，使用一个很小的负数（这里用-100000）
        // 注意：这里有个小问题，应该直接用dp[0]初始化
        int res = dp[0];
        // 从第二个元素开始遍历
        for (int i = 1; i < nums.length; i++) {
            // 状态转移方程：
            // 要么只包含当前元素nums[i]
            // 要么包含当前元素并延续之前的子数组dp[i-1]
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            // 更新全局最大值
            res = Math.max(res, dp[i]);
        }
        // 打印dp数组用于调试（可以看到每个位置的最大子数组和）
        System.out.println(Arrays.toString(dp));
        // 返回全局最大值
        return res;
    }
}
