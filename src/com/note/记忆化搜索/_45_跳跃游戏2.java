package com.note.记忆化搜索;

public class _45_跳跃游戏2 {
    public int jump(int[] nums) {
        dp = new int[nums.length];
        return dfs(nums, 0);
    }

    int dp[];

    int dfs(int[] nums, int idx) {
        // 1. 基准情况：已到达或越过终点
        if (idx >= nums.length - 1) return 0;
        // 2. 记忆化检查：若当前状态已计算过，直接返回结果
        if (dp[idx] != 0) return dp[idx];

        // 3. 初始化最小跳跃次数为一个极大值（表示不可达）
        int ans = 100000;
        // 4. 递归探索：尝试所有可能的跳跃步数（1 到 nums[idx]）
        for (int i = 1; i <= nums[idx]; i++) {
            //这里的 +1表示从当前位置 idx跳到新位置 idx + i需要一次跳跃。记录跳跃次数
            ans = Math.min(ans, dfs(nums, idx + i) + 1);
        }

        // 5. 存储结果并返回
        dp[idx] = ans;
        return ans;
    }

    public static void main(String[] args) {
        new _45_跳跃游戏2().jump(new int[]{2, 3, 1, 1, 4});
    }
}
