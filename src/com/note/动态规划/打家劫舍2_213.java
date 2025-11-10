package com.note.动态规划;

import java.util.Arrays;

public class 打家劫舍2_213 {
    /**
     * 解决环形房屋打家劫舍问题（LeetCode 213）
     * 由于房屋围成一圈，第一间和最后一间相邻不能同时偷窃，故分解为两个线性问题：
     * 1. 考虑偷窃第一间房屋，但不偷最后一间（范围[0, n-2]）
     * 2. 考虑偷窃最后一间房屋，但不偷第一间（范围[1, n-1]）
     * 最终结果为两种情况的最大值
     */
    public int rob(int[] nums) {
        // 边界情况处理：只有一间房屋时直接返回其金额
        if (nums.length == 1) return nums[0];
        // 边界情况处理：只有两间房屋时（环形相邻）返回金额较大的那个
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        // 第一种情况：偷窃第一间房屋，但不偷最后一间（计算范围从0到nums.length-2）
        int[] dp = new int[nums.length - 1]; // dp数组记录从第0间到当前房屋能偷到的最大金额
        dp[0] = nums[0]; // 只有第0间房屋时，最大金额就是nums[0]
        dp[1] = Math.max(nums[0], nums[1]); // 前两间房屋，取金额较大的那个
        // 动态规划过程：从第2间房屋开始到倒数第二间房屋结束
        for (int i = 2; i < nums.length - 1; i++) {
            // 状态转移方程：偷当前房屋（dp[i-2] + nums[i]） vs 不偷当前房屋（dp[i-1]）
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        // 第二种情况：偷窃最后一间房屋，但不偷第一间（计算范围从1到nums.length-1）
        int[] dp1 = new int[nums.length]; // dp1数组记录从第1间到当前房屋的最大金额
        dp1[0] = 0; // 不偷第0间房屋，金额为0
        dp1[1] = nums[1]; // 只有第1间房屋时，最大金额为nums[1]
        dp1[2] = Math.max(nums[1], nums[2]); // 第1和第2间房屋，取金额较大的那个
        // 动态规划过程：从第3间房屋开始到最后一件房屋结束
        for (int i = 3; i < nums.length; i++) {
            // 状态转移方程同上
            dp1[i] = Math.max(dp1[i - 2] + nums[i], dp1[i - 1]);
        }
        // 调试输出，可删除
        System.out.println(Arrays.toString(dp1));
        System.out.println(Arrays.toString(dp));
        // 返回两种情况的最大值：dp[dp.length-1]是第一种情况结果，dp1[dp1.length-1]是第二种情况结果
        return Math.max(dp[dp.length - 1], dp1[dp1.length - 1]);
    }
}
