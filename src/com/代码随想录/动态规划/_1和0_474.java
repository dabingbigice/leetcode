package com.代码随想录.动态规划;

public class _1和0_474 {
    public int findMaxForm(String[] strs, int m, int n) {
        // 创建二维动态规划数组，dp[j][k]表示使用j个0和k个1时能构成的最大子集长度
        int[][] dp = new int[m + 1][n + 1];

        // 遍历每个字符串（每个物品）
        for (int i = 0; i < strs.length; i++) {
            String str1 = strs[i];

            // 统计当前字符串中0和1的个数（相当于物品的两种重量）
            int x = 0; // 当前字符串中0的个数
            int y = 0; // 当前字符串中1的个数

            for (int j = 0; j < str1.length(); j++) {
                if (str1.charAt(j) == '1')
                    y++; // 统计1的个数
                else
                    x++; // 统计0的个数
            }

            // 二维背包核心逻辑：从后往前遍历，确保每个字符串只被使用一次。判断是否能放入
            for (int j = m; j >= x; j--) {     // 遍历0的容量，从大到小防止重复使用（放入0）
                for (int k = n; k >= y; k--) { // 遍历1的容量，从大到小防止重复使用（放入1）
                    // 状态转移方程：选择当前字符串或不选择当前字符串的最大值
                    dp[j][k] = Math.max(
                            dp[j][k],                    // 不选当前字符串：继承之前的状态
                            dp[j - x][k - y] + 1         // 选择当前字符串：减去当前字符串的0和1消耗，子集数量+1
                    );
                }
            }
        }

        // 返回结果：使用m个0和n个1时能构成的最大子集长度
        return dp[m][n];
    }
}
