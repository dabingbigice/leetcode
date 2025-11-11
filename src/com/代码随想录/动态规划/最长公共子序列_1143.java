package com.代码随想录.动态规划;

public class 最长公共子序列_1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        // 创建动态规划表dp，维度为 (len(text1)+1) x (len(text2)+1)
        // dp[i][j] 表示 text1 的前 i 个字符（即text1[0:i-1]）与 text2 的前 j 个字符（即text2[0:j-1]）的最长公共子序列的长度
        // 多出的一行一列（索引0）用于处理空字符串的边界情况，初始值默认为0[3,8](@ref)
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        // 双重循环填充dp表：i 从1到text1长度，j 从1到text2长度
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                // 检查当前字符是否相等（注意dp索引i、j对应字符串索引需减1）
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // 字符相等：当前LCS长度 = 左上角子问题（去掉当前字符的子序列）的LCS长度 + 1
                    // 因为当前字符可加入公共子序列[2,5](@ref)
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 字符不相等：当前LCS长度 = 左子问题（text1[0:i-1]和text2[0:j]）或上子问题（text1[0:i]和text2[0:j-1]）的较大值
                    // 即舍弃text1的当前字符或text2的当前字符，选择能保留更长公共子序列的情况[4,7](@ref)
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        // 返回整个字符串的LCS长度，即dp表右下角的值[3,8](@ref)
        return dp[text1.length()][text2.length()];
    }
}
