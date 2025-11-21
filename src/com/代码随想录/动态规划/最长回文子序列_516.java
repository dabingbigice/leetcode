package com.代码随想录.动态规划;

import com.sun.tools.javac.util.StringUtils;

public class 最长回文子序列_516 {
    public int longestPalindromeSubseq(String s) {
        // 1. 创建原字符串的反转字符串
        // 原理：一个字符串的最长回文子序列，就是它和其反转字符串的最长公共子序列(LCS)
        StringBuffer reverse = new StringBuffer(s).reverse();
        String r = reverse.toString();
        // 2. 初始化动态规划表dp
        // dp[i][j] 表示：原字符串s的前i个字符 和 反转字符串r的前j个字符 的最长公共子序列的长度
        // 数组长度+1是为了方便处理空字符串的情况（即前0个字符）
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        // 3. 动态规划填表
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= r.length(); j++) {
                // 3.1 如果当前字符匹配（原字符串的第i个字符 等于 反转字符串的第j个字符）
                if (s.charAt(i-1) == r.charAt(j-1)) {
                    // 当前LCS长度 = 各自去掉当前字符时的LCS长度 + 1
                    // 因为当前匹配的字符可以加入到公共子序列中
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 3.2 如果当前字符不匹配
                    // 当前LCS长度 = max(去掉原字符串当前字符时的LCS, 去掉反转字符串当前字符时的LCS)
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        // 4. 返回结果：整个字符串s和整个反转字符串r的最长公共子序列长度
        // 这就是原字符串的最长回文子序列的长度
        return dp[dp.length-1][dp.length-1];
    }
}
