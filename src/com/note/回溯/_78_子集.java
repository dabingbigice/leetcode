package com.note.回溯;

import java.util.ArrayList;
import java.util.List;

public class _78_子集 {
    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, new ArrayList<>(), nums);
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();
    void dfs(int index, List<Integer> path, int[] nums) {
        if (index == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (index < nums.length) {
            res.add(new ArrayList<>(path));
        }

        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(i + 1, path, nums);
            path.remove(path.size() - 1);
        }

    }
}
