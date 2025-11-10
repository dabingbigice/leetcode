package com.代码随想录.动态规划;

public class 打家劫舍_198 {
    public int rob(int[] nums) {
        // 创建dp数组，dp[i] 表示偷窃到第i个房屋时能获得的最高金额
        int[] dp = new int[nums.length];
        // 边界情况：如果只有一间房屋，只能偷这一家
        if (nums.length == 1) return nums[0];
        // 初始化前两个基础状态
        dp[0] = nums[0]; // 只有一间房，最大金额就是它本身的金额
        dp[1] = Math.max(nums[0], nums[1]); // 两间房，选择金额较大的那间偷窃
        // 动态规划核心：从第三间房开始计算每个位置的最优解
        for (int i = 2; i < nums.length; i++) {
            // 关键决策：偷当前房屋 或 不偷当前房屋
            dp[i] = Math.max(dp[i - 1],          // 不偷第i间：继承前i-1间的最高金额
                    dp[i - 2] + nums[i]); // 偷第i间：前i-2间的最高金额 + 当前房屋金额
        }
        // 返回偷窃到最后一间房屋时的最高金额
        return dp[nums.length - 1];
    }
}
