package com.note.回溯;

import java.util.HashSet;
import java.util.Set;

public class _698_划分为k个相等的子集 {

    int avg = -1;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) return false;
        avg = sum / k;
        return dfs(nums, k, 0, new int[k]);
    }

    boolean dfs(int[] nums, int k, int idx, int[] sub) {
        if (idx == nums.length) {
            //判断是否满足了
            for (int i : sub) {
                if (i != avg) return false;
            }
            //满足
            return true;
        }
        //剪枝
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < k; i++) {
            //操作sub+nums[idx]，循环自己的分组
            if (sub[i] + nums[idx] > avg || set.contains(sub[i])) continue;
            //剪枝，此和已尝试
            set.add(sub[i]);
            sub[i] += nums[idx];
            if (dfs(nums, k, idx + 1, sub)) return true;
            sub[i] -= nums[idx];
        }
        return false;
    }
}
