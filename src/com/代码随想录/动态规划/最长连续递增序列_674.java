package com.代码随想录.动态规划;

import java.util.Arrays;

public class 最长连续递增序列_674 {
    public int findLengthOfLCIS(int[] nums) {
        // 处理边界情况：如果数组为空或只有一个元素，直接返回数组长度
        if (nums.length == 0) return 0;
        // dp[i] 表示以 nums[i] 结尾的最长连续递增子序列的长度
        int[] dp = new int[nums.length];
        // 初始化dp数组，每个元素自身至少可以构成一个长度为1的连续递增序列
        Arrays.fill(dp, 1);
        // max 记录全局最长连续递增子序列的长度
        int max = 1;
        // 从第二个元素开始遍历数组
        for (int i = 1; i < nums.length; i++) {
            // 如果当前元素大于前一个元素，说明连续递增序列可以延长
            if (nums[i] > nums[i - 1]) {
                // 以当前元素结尾的最长连续递增序列长度 = 前一个元素的长度 + 1
                dp[i] = dp[i - 1] + 1;
            }
            // 更新全局最大值
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
