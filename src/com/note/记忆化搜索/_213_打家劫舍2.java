package com.note.记忆化搜索;

import java.util.Arrays;

public class _213_打家劫舍2 {

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        int temp0 = dfs(nums, 0, nums.length - 1);
        Arrays.fill(dp, -1);

        int temp1 = dfs(nums, 1, nums.length);
        return Math.max(temp0, temp1);
    }

    int[] dp;

    int dfs(int[] nums, int idx, int end) {
        if (idx >= end) return 0;
        if (dp[idx] != -1) return dp[idx];
        int skipCurrent = dfs(nums, idx + 1, end);
        // 选择二：偷当前房屋，那么下一间房屋不能偷，只能从下下间(idx+2)开始偷，并加上当前房屋的金额
        int robCurrent = dfs(nums, idx + 2, end) + nums[idx];
        //偷了最后一个
        return dp[idx] = Math.max(skipCurrent, robCurrent);
    }

    public static void main(String[] args) {
//        new _213_打家劫舍2().rob(new int[]{2, 7, 9, 3, 1});
//        new _213_打家劫舍2().rob(new int[]{2, 1, 1, 2});
        new _213_打家劫舍2().rob(new int[]{1, 2, 3, 1});
    }
}
