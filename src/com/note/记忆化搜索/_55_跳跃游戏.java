package com.note.记忆化搜索;

public class _55_跳跃游戏 {
    public boolean canJump(int[] nums) {
        dp = new int[nums.length];
        return dfs(nums, 0);
    }

    int dp[];

    boolean dfs(int[] nums, int idx) {
        // 1. 基准情况：已到达或越过终点
        if (idx >= nums.length - 1) return true;
        // 2. 记忆化检查：若当前状态已计算过，直接返回结果
        if (dp[idx] != 0) return dp[idx] == 1;

        // 3. 递归探索：尝试所有可能的跳跃步数
        for (int i = 1; i <= nums[idx]; i++) {
            // 尝试跳跃 i 步到新位置 idx + i，并递归检查
            if (dfs(nums, idx + i)) {
                dp[idx] = 1; // 记录成功状态
                return true;
            }
        }
        // 4. 搜索失败：所有尝试都失败，记录失败状态
        dp[idx] = -1;
        return false;
    }
}
