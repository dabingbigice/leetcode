package com.note.动态规划;

import java.util.Arrays;

public class 最后一块石头的重量II_1049 {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int target = sum >> 1;
        int[] dp = new int[target + 1];
        for (int i = 1; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], stones[i] + dp[j - stones[i]]);
            }
        }
        System.out.println(Arrays.toString(dp));
        return sum - dp[target] * 2;
    }
}
