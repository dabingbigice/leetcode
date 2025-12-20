package com.代码随想录.二刷._01背包;

import java.util.Arrays;

public class _494目标和_背 {
    public int findTargetSumWays(int[] nums, int target) {
        //划分集合，正集合与负集合。最终这两个集合相加是否等于target
        //dp0=1;
        //推导出,只有dp[j-nums[i]]==dp[0]时+dp[j]才能有满足的方案

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (Math.abs(target) > sum) return 0;
        int p = (sum + target);
        if (p % 2 != 0) return 0;
        p = p >> 1;
        p = Math.abs(p);
        //寻找正集合数值为p的方法种数
        int[] dp = new int[p + 1];
        //组成0有一种方法
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = p; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }

        }
        System.out.println(Arrays.toString(dp));
        return dp[dp.length - 1];
    }
}
