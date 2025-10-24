package com.note.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _39_组合总和 {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, 0, 0, new LinkedList<>());
        return list;
    }

    int dfs(int[] candidates, int target, int k, int sum, List<Integer> path) {
        if (sum == target) {
            list.add(new LinkedList<>(path));
            return sum;
        }
        if (sum > target) return sum;
        for (int i = k; i < candidates.length; i++) {
            path.add(candidates[i]);
            int num = dfs(candidates, target, i, sum + candidates[i], path);
            path.remove(path.size() - 1);
        }
        return 0;
    }

    void dfs1(int[] candidates, int target, int k, int sum, List<Integer> path) {
        if (sum == target) {
            list.add(new LinkedList<>(path));
            return;
        }
        if (sum > target) {return;}
        for (int i = k; i < candidates.length; i++) {
            path.add(candidates[i]);
            sum += candidates[i];
            dfs(candidates, target, i, sum, path);
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        new _39_组合总和().combinationSum(new int[]{2, 3, 6, 7}, 7);
    }
}
