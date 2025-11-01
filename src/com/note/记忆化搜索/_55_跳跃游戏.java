package com.note.记忆化搜索;

public class _55_跳跃游戏 {
    public boolean canJump(int[] nums) {
        dp = new int[nums.length];
        return dfs(nums, 0);
    }

    int dp[];

    boolean dfs(int[] nums, int idx) {
        if (idx >= nums.length-1) return true;
        if (dp[idx] != 0) return dp[idx] == 1;
        for (int i = 1; i <= nums[idx]; i++) {
            //跳i步，i要<=当前索引数据的大小
            if (dfs(nums, idx + i)) {
                dp[idx] = 1;
                return true;
            }
        }
        dp[idx] = -1;
        return false;
    }
}
