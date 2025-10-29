package com.note.记忆化搜索;

import java.lang.reflect.Array;
import java.util.Arrays;

public class _198_打家劫舍 {
    public int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        int res= dfs(0, nums);
        return  res;

    }

    int[] dp;
    /*
    * 递归到最深处偷，依次累加找到最大值
    * */
    int dfs(int idx, int[] nums) {
        // 基准情况：如果索引超出数组范围，说明没有房屋可偷，收益为0
        if (idx >= nums.length) return 0;

        // 记忆化检查：如果当前状态已经计算过，直接返回存储的结果
        if (dp[idx] != -1) return dp[idx];

        // 核心决策：对于当前房屋idx，有两种选择
        // 选择一：不偷当前房屋，那么可以考虑从下一间房屋(idx+1)开始偷
        int skipCurrent = dfs(idx + 1, nums);
        // 选择二：偷当前房屋，那么下一间房屋不能偷，只能从下下间(idx+2)开始偷，并加上当前房屋的金额
        int robCurrent = dfs(idx + 2, nums) + nums[idx];

        // 取两种选择中的最大值作为从idx开始的最大收益，并存入备忘录
        return dp[idx] = Math.max(skipCurrent, robCurrent);
    }

    public static void main(String[] args) {
//        new _198_打家劫舍().rob(new int[]{1,2,3,1});
//        new _198_打家劫舍().rob(new int[]{2,7,9,3,1});
        new _198_打家劫舍().rob(new int[]{2, 1, 1, 2});
    }
}
