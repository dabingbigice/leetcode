package com.代码随想录.动态规划;

import java.util.Arrays;

public class 最长递增子序列_300 {
    public int lengthOfLIS(int[] nums) {
        // 处理边界情况：如果数组为空或只有一个元素，最长递增子序列长度就是数组长度本身
        if (nums.length <= 1) return nums.length;
        // 创建dp数组，dp[i]表示以nums[i]结尾的最长递增子序列的长度
        int[] dp = new int[nums.length];
        // 初始化dp数组：每个元素自身至少可以构成一个长度为1的递增子序列
        Arrays.fill(dp, 1);
        // 动态规划填表过程：计算每个位置i的dp[i]值
        for (int i = 1; i < nums.length; i++) {
            //算法的逻辑是判断多少个元素能放入j之后，然后取最大的dp角标，代表该元素后可以放最多的子序列。
            // 内层循环：检查i之前的所有元素j，看是否能将nums[i]接在j之后的子序列上
            for (int j = 0; j < i; j++) {
                // 如果nums[i]大于nums[j]，说明nums[i]可以接在以nums[j]结尾的递增子序列之后
                // 更新dp[i]为当前值和dp[j]+1中的较大值，表示选择更长的子序列
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        // 对dp数组排序，最后一个元素即为最大值，即整个数组的最长递增子序列长度
        Arrays.sort(dp);
        return dp[dp.length - 1];
    }
}
