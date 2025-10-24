package com.note.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _216_组合总和3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(k, n, new LinkedList<>(), 0, 1, 9);
        return list;
    }

    List<List<Integer>> list = new ArrayList<>();

    void dfs(int k, int target, List<Integer> path, int sum, int start, int end) {
        if (path.size() > k) return;
        if (sum >= target || path.size() == k) {
            if (sum == target && path.size() == k) {
                list.add(new LinkedList<>(path));
                return;
            }
            return;
        }
        for (int i = start; i <= end; i++) {
            path.add(i);
            dfs(k, target, path, sum + i, i + 1, 9);
            path.remove(path.size() - 1);
        }

    }

    public static void main(String[] args) {
        new _216_组合总和3().combinationSum3(9,45);
    }
}
