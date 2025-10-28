package com.note.回溯;

import java.util.ArrayList;
import java.util.List;

public class _46_全排列 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        dfs(new boolean[nums.length], new ArrayList<>(), nums);
        return res;
    }

    void dfs(boolean[] used, List<Integer> path, int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }


        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                path.add(nums[i]);
                dfs(used, path, nums);
                //回溯
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        new _46_全排列().permute(new int[]{1,2,3});
    }
}
