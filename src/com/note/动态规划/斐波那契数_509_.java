package com.note.动态规划;

import java.util.Arrays;

public class 斐波那契数_509_ {
    int dp[];

    public int fib(int n) {
        if (n <= 1) return n;
        dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(Arrays.toString(dp));
        return dp[dp.length - 2];
    }

    public static void main(String[] args) {
        new 斐波那契数_509_().fib(4);
    }
}
