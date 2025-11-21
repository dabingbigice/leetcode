package com.代码随想录.动态规划;

public class 回文子串_647 {
    public int countSubstrings(String s) {
        // 创建动态规划表dp，dp[i][j]表示字符串s从索引i到j的子串是否为回文串
        boolean[][] dp = new boolean[s.length()][s.length()];
        int res = 0; // 记录回文子串的总数

        // 从字符串末尾向前遍历，i表示子串的起始位置
        for (int i = s.length() - 1; i >= 0; i--) {
            // j表示子串的结束位置，从i开始（因为结束位置不能小于起始位置）
            for (int j = i; j < s.length(); j++) {
                // 只有当首尾字符相同时，才可能构成回文串
                if (s.charAt(i) == s.charAt(j)) {
                    // 情况1：子串长度<=2（即j-i<=1）
                    // 单个字符（a）或两个相同字符（aa）一定是回文串
                    if (j - i <= 1) {
                        dp[i][j] = true; // 标记为回文子串
                        res++; // 回文子串数量加1
                    }
                    // 情况2：子串长度>2，需要检查去掉首尾后的内部子串是否为回文
                    else if (dp[i + 1][j - 1]) {
                        dp[i][j] = true; // 内部是回文，则整个子串也是回文
                        res++; // 回文子串数量加1
                    }
                }
                // 如果首尾字符不同，dp[i][j]保持默认值false，不进行任何操作
            }
        }
        return res; // 返回回文子串的总数
    }
}
