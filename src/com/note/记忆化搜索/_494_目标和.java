package com.note.记忆化搜索;


public class _494_目标和 {
    int dp[];

    public int findTargetSumWays(int[] nums, int target) {
        dp = new int[nums.length];
        return dfs(nums, 0, 0, target);
    }


    int dfs(int[] nums, int idx, int sum, int target) {
        if (idx == nums.length) return target == sum ? 1 : 0;
        //从前完后加 +1 -1 +1 -1 +1 
        int add = dfs(nums, idx + 1, sum + nums[idx], target);
        int sub = dfs(nums, idx + 1, sum - nums[idx], target);
        return add + sub;
    }

    public static void main(String[] args) {
        new _494_目标和().dfs(new int[]{1, 1, 1, 1, 1}, 0, 0, 3);
    }
}
