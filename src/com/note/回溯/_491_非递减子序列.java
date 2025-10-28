package com.note.回溯;

import java.util.*;

public class _491_非递减子序列 {
    Set<List<Integer>> res = new HashSet<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(0, new LinkedList<>(), nums);
        return new ArrayList<>(res);
    }


    void dfs(int index, List<Integer> path, int[] nums) {
        if (path.size() >= 2) {
            res.add(new LinkedList<>(path));
        }
        Set<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (path.size() > 0 && path.get(path.size() - 1) > nums[i] || set.contains(nums[i])) continue;
            set.add(nums[i]);
            path.add(nums[i]);
            dfs(i + 1, path, nums);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        new _491_非递减子序列().findSubsequences(new int[]{4, 4, 3, 2, 1});
    }
}
