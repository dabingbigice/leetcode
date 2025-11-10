package com.note.动态规划;

import java.util.Arrays;

public class 打家劫舍2_213 {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int[] dp = new int[nums.length - 1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        //从0.....nums.len-1
        for (int i = 2; i < nums.length - 1; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        int[] dp1 = new int[nums.length];
        dp1[0] = 0;
        dp1[1] = nums[1];
        dp1[2] = Math.max(nums[1], nums[2]);
        //从1.....nums.len
        for (int i = 3; i < nums.length; i++) {
            dp1[i] = Math.max(dp1[i - 2] + nums[i], dp1[i - 1]);
        }
        System.out.println(Arrays.toString(dp1));
        System.out.println(Arrays.toString(dp));
        return Math.max(dp[dp.length - 1], dp1[dp1.length - 1]);
    }
}
