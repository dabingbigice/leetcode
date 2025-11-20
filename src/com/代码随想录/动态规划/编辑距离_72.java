package com.代码随想录.动态规划;

public class 编辑距离_72 {
    public int minDistance(String word1, String word2) {
        // 创建动态规划表dp，dp[i][j]表示将word1的前i个字符转换为word2的前j个字符所需的最小操作次数[1,6](@ref)
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        // 初始化：当word2为空字符串时，需要删除word1的所有字符（操作次数等于word1的长度）[1,8](@ref)
        for (int i = 1; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        // 初始化：当word1为空字符串时，需要插入word2的所有字符（操作次数等于word2的长度）[1,8](@ref)
        for (int j = 1; j <= word2.length(); j++) {
            dp[0][j] = j;
        }
        // 动态规划填表：从第一个字符开始逐步计算子问题[6,8](@ref)
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                // 当前字符相同，无需操作，继承前一个子问题的解[5,6](@ref)
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 当前字符不同，选择三种操作中的最小值：
                    // 1. dp[i-1][j] + 1: 删除word1的第i个字符（等价于在word2插入）[2,6](@ref)
                    // 2. dp[i][j-1] + 1: 删除word2的第j个字符（等价于删除word2）[2,6](@ref)
                    // 3. dp[i-1][j-1] + 1: 替换word1的第i个字符为word2的第j个字符[2,6](@ref)
                    dp[i][j] = Math.min(dp[i - 1][j] + 1,
                            Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1));
                }
            }
        }
        // 返回将整个word1转换为word2的最小编辑距离[1,8](@ref)
        return dp[word1.length()][word2.length()];
    }
}
