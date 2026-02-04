package com.代码随想录.二刷.动态规划.子序列;

public class _647回文子串 {
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            //j++[i,j]
            for (int j = i; j < s.length(); j++) {
                //i=j时,自己肯定回文,是个对角矩阵。
                if (s.charAt(i) == s.charAt(j)) {
                    //aba
                    //从这个例子可以看出，正是因为外层循环 i从2倒序到0，当计算最关键的 dp[0][2]（即整个字符串 "aba"）时，
                    // 它所依赖的内部子串 dp[1][1]（即 "b"）已经在步骤2中计算完毕，值为 true，所以才能正确判断 "aba"是回文串。
                    if (j - i <= 1) {
                        dp[i][j] = true;
                        res++;
                    } else if (dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
