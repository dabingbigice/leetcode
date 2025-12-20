package com.代码随想录.二刷._01背包;

public class _474一和零 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < strs.length; i++) {
            String st = strs[i];

            int x = 0;
            int y = 0;
            for (int j = 0; j < st.length(); j++) {
                if (st.charAt(j) == '0') x++;
                else y++;
            }
            //背包重量减少
            for (int j = m; j >= x; j--) {
                for (int k = n; k >= y; k--) {
                    dp[j][k] = Math.max(dp[j][k],
                            dp[j - x][k - y] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        new _474一和零().findMaxForm(new String[]{"10", "0", "1"}, 1, 1);
    }
}
