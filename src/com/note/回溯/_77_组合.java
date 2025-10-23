package com.note.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _77_组合 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(n, k, new LinkedList<>(), 1);
        return res;
    }

    void dfs(int n, int k, List<Integer> path, int index) {
        if (path.size() == k) {
            res.add(new LinkedList<>(path));
            return;
        }

        for (int i = index; i <= n; i++) {
            path.add(i);
            dfs(n, k, path, i + 1);
            //每层结束删除自己的节点，开始下一层
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        _77_组合 v = new _77_组合();
        v.combine(4, 2);
    }
}
