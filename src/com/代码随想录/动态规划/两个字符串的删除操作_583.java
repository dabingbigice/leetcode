package com.代码随想录.动态规划;

public class 两个字符串的删除操作_583 {
    /**
     * 实现原理：
     * 1. 定义dp[i][j]表示将word1的前i个字符转换为word2的前j个字符所需的最小编辑距离
     * 2. 通过填充二维DP表，逐步计算所有子问题的解
     * 3. 最终结果存储在dp[m][n]中，其中m和n分别是两个字符串的长度
     *
     * 参考：动态规划解编辑距离的标准实现[1,6](@ref)
     */
    public int minDistance(String word1, String word2) {
        // 创建DP表，尺寸为(length+1)x(length+1)，多出一行一列用于处理空字符串情况
        // dp[i][j]表示word1前i个字符转换为word2前j个字符的最小编辑距离[6](@ref)
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        // 初始化第一列：将word1前i个字符转换为空字符串需要i次删除操作
        // 例如：将"abc"转换为""需要3次删除[2,6](@ref)
        for (int i = 1; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        // 初始化第一行：将空字符串转换为word2前j个字符需要j次插入操作
        // 例如：将""转换为"abc"需要3次插入[2,6](@ref)
        for (int j = 1; j <= word2.length(); j++) {
            dp[0][j] = j;
        }
        // 填充DP表，从1开始遍历（因为0行0列已初始化）
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                // 检查当前字符是否匹配（注意索引偏移：i-1和j-1对应实际字符位置）
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // 字符匹配：不需要操作，继承左上角的值[6](@ref)
                    // 例如："ab"到"ab"的距离等于"a"到"a"的距离
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(
                            dp[i - 1][j] + 1,     // 删除：删除word1当前字符，代价1
                            Math.min(
                                    dp[i][j - 1] + 1,     // 删除：删除word2当前字符，代价1
                                    dp[i - 1][j - 1] + 2 // 删除两个
                            )
                    );
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
