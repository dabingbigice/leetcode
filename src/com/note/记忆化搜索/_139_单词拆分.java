package com.note.记忆化搜索;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _139_单词拆分 {
    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        dp = new int[s.length()];
        return dfs(s, wordDict, 0);
    }

    Set<String> set;
    int dp[];

    boolean dfs(String s, List<String> wordDict, int idx) {
        // 基准情况：已到达字符串末尾，成功分割
        if (s.length() == idx) return true;
        // 记忆化检查：如果当前状态已计算过，直接返回结果
        if (dp[idx] != 0) return dp[idx] == 1;

        for (int i = idx + 1; i <= s.length(); i++) {
            String sub = s.substring(idx, i); // 截取子串 s[idx, i-1]
            // 如果子串在字典中，并且剩余部分也能被分割，则成功
            if (set.contains(sub) && dfs(s, wordDict, i)) {
                dp[idx] = 1; // 记录成功状态
                return true;
            }
        }
        // 从当前索引开始匹配，所有分割尝试都失败，记录失败状态，当前索引开始不行
        dp[idx] = -1;
        return false;
    }
}
