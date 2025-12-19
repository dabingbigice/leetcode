package com.代码随想录.二刷;

public class _343整数拆分 {
    public int integerBreak(int n) {
        //定义dpi,初始化，遍历顺序，递推公式
        //定义dpi是拆分到i的最大乘积
        int dp[] = new int[n + 1];
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                //对i进行拆分，拆到i-1,循环拆,需要去到所有拆分的最大值,//拆成2个数，拆成>=3个数
                dp[i] = Math.max(dp[i], Math.max((i - j) * j, dp[i - j] * j));
            }
        }
        return dp[n];
    }
}
