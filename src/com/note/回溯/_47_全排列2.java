package com.note.回溯;

import java.util.*;

public class _47_全排列2 {
    Set<List<Integer>> res = new HashSet<>();
    Map<Integer, Integer> map = new HashMap<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        //统计次数
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        Arrays.sort(nums);
        dfs(nums, new ArrayList<>(), map);
        return new ArrayList<>(res);
    }

    void dfs(int[] nums, List<Integer> path, Map<Integer, Integer> map) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] || map.get(nums[i]) == 0) continue;
            //添加
            path.add(nums[i]);
            map.put(nums[i], map.get(nums[i]) - 1);
            dfs(nums, path, map);
            //回溯
            path.remove(path.size() - 1);
            map.put(nums[i], map.get(nums[i]) + 1);
        }
    }

    public static void main(String[] args) {
        new _47_全排列2().permuteUnique(new int[]{1, 1, 3});
    }
}
