package com.note.动态规划;

import java.util.Arrays;

public class 整数拆分_343 {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i < dp.length; i++) {
            for (int j = 1; j < i; j++) {
                //拆/不拆，谁的值大，取大值放入dp，避免下一次再进行拆分
                dp[i] = Math.max(dp[i],Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }

    public static void main(String[] args) {
        new 整数拆分_343().integerBreak(10);
    }
}
