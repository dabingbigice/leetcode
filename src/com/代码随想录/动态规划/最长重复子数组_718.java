package com.代码随想录.动态规划;

public class 最长重复子数组_718 {
    public int findLength(int[] nums1, int[] nums2) {
        // 定义dp数组：dp[i][j] 表示以 nums1[i-1] 和 nums2[j-1] 结尾的最长公共子数组的长度
        // 使用长度+1是为了方便处理边界条件，dp[0][j]和dp[i][0]代表空数组的情况，初始值为0[5](@ref)
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        // 初始化：dp数组已默认初始化为0，符合逻辑（空数组无公共子数组）
        int max = 0; // 记录全局最长公共子数组的长度
        // 动态规划填表：i和j从1开始，对应原数组的索引需要-1[5](@ref)
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                // 当前元素相等时，可扩展公共子数组的长度[5](@ref)
                if (nums1[i - 1] == nums2[j - 1]) {
                    // 状态转移：当前长度 = 前一个状态的长度 + 1[5](@ref)
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                // 若不相等，dp[i][j]保持为0（无需显式赋值，因为数组已初始化为0）
                // 更新全局最大值
                max = Math.max(dp[i][j], max);
            }
        }
        return max; // 返回最终结果
    }
}
