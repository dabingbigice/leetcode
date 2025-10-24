package com.note.回溯;

import java.util.*;

public class _40_组合总和2 {
    List<List<Integer>> list = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new ArrayList<>(), 0);
        return list;
    }


    void dfs(int[] candidates, int target, int sum, List<Integer> path, int k) {
        if (sum == target) {

            list.add(new LinkedList<>(path));
            return;
        }
        if (sum > target) return;

        for (int i = k; i < candidates.length; i++) {
            if (candidates[i] + sum > target) continue;
            if (i > k && candidates[i] == candidates[i - 1]) continue;
            path.add(candidates[i]);
            dfs(candidates, target, sum + candidates[i], path, i + 1);
            path.remove(path.size() - 1);
        }

    }

    public static void main(String[] args) {
        new _40_组合总和2().combinationSum2(new int[]{2, 5, 2, 1, 2}, 5);
    }
}
