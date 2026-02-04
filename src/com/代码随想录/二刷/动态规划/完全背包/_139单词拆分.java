package com.代码随想录.二刷.动态规划.完全背包;

import java.util.List;

public class _139单词拆分 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] res = new boolean[s.length() + 1];
        res[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (wordDict.contains(s.substring(j, i)) && res[j]) {
                    res[i] = true;
                }
            }

        }
        return res[s.length()];
    }
}
