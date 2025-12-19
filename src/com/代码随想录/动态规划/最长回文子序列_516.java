package com.代码随想录.动态规划;


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
                if (s.charAt(i - 1) == r.charAt(j - 1)) {
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
        return dp[dp.length - 1][dp.length - 1];
    }


    public int longestPalindromeSubseq1(String s) {
        int len = s.length();
        // 创建DP表，dp[i][j]表示字符串s从索引i到索引j（闭区间）的子串中最长回文子序列的长度
        int[][] dp = new int[len + 1][len + 1]; // 维度为len+1是为了编程方便，实际有效区间为[0, len-1]
        // 外层循环：从字符串末尾向前遍历起始索引i（自底向上填充DP表，确保子问题先于父问题解决）
        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1; // 基础情况：单个字符的子串本身就是回文，长度为1
            // 内层循环：遍历结束索引j（从i+1开始，因为j必须大于i）
            for (int j = i + 1; j < len; j++) {
                // 情况1：当前首尾字符相等
                if (s.charAt(i) == s.charAt(j)) {
                    // 当前子串的最长回文长度 = 内部子串(i+1, j-1)的最长回文长度 + 2（新增的首尾两个字符）
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    // 情况2：首尾字符不相等
                    // 最长回文可能存在于去掉首字符的子串(i+1, j)或去掉尾字符的子串(i, j-1)中
                    // 注意：此处原代码为 Math.max(dp[i + 1][j], Math.max(dp[i][j], dp[i][j - 1]))，
                    // 其中 dp[i][j] 是多余的（因为此时它尚未被计算，值为0）。应简化为：
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]); // 修正后的逻辑
                }
            }
        }
        // 返回整个字符串s[0, len-1]的最长回文子序列长度
        return dp[0][len - 1];
    }
}
