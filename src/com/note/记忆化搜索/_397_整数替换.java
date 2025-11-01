package com.note.记忆化搜索;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _397_整数替换 {
    public int integerReplacement(int n) {
        return dfs(n);
    }

    Map<Long, Integer> map = new HashMap<>();

    int dfs(long n) {
        if (n == 1) return 0;
        if (map.containsKey(n)) return map.get(n);
        int ans = 0;
        if (n % 2 == 0) {
            //dfs(n + 1), dfs(n - 1)会重复的进入计算n % 2
            ans = dfs(n / 2) + 1;
        } else {
            ans = Math.min(dfs(n + 1), dfs(n - 1)) + 1;
        }
        map.put(n, ans);
        return ans;
    }

    public static void main(String[] args) {
        new _397_整数替换().integerReplacement(8);
    }
}
