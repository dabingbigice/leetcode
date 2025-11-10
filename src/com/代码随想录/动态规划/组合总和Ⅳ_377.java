package com.代码随想录.动态规划;

import java.util.Arrays;

public class 组合总和Ⅳ_377 {
    public int combinationSum4(int[] nums, int target) {
        //组合数。方案个数
        //定义dp[j]表示满足target为j的组合总数
        int[] dp = new int[target + 1];
        //初始化
        dp[0] = 1;
        //递推式 dp[j] = dp[j]+dp[j-weight[i]]
        for (int i = 1; i <= target; i++) {//背包
            for (int j = 0; j < nums.length; j++) {//物品
                //物品进行组合
                if (nums[j] <= i) dp[i] = dp[i] + dp[i - nums[j]];
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[target];
    }
}
