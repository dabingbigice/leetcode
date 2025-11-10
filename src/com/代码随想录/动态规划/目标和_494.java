package com.代码随想录.动态规划;

import java.util.Arrays;

public class 目标和_494 {
    public int findTargetSumWays(int[] nums, int target) {
        //将组合划分为子集。寻找一个满足条件的子集，另外一个子集自然就满足条件了。
        // 计算数组所有元素的总和
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 边界条件检查：
        // 1. 如果目标值的绝对值大于总和，说明无法实现，直接返回0 [3,5](@ref)
        if (Math.abs(target) > sum) return 0;
        // 2. 如果 (target + sum) 是奇数，则无解（因为数学推导要求其为偶数）[3,5](@ref)
        if ((target + sum) % 2 == 1) return 0;
        // 核心数学转化：将问题转化为子集和问题（01背包）[3,5](@ref)
        // 设正数子集和为 P，负数子集和为 N，则有：找到正数子集P的方法数量
        // P + N = sum 且 P - N = target → 2P = target + sum → P = (target + sum) / 2
        //转移为组成子集P的总数量
        // 这里使用右移1位代替除以2，优化计算效率 [4](@ref)
        int add = (target + sum) >> 1;
        // 注意：add 可能为负数，需取绝对值确保数组大小非负 [2](@ref)
        int absAdd = Math.abs(add);
        // 初始化动态规划数组 dp，dp[j] 表示和为 j 的子集数量 [3,5](@ref)
        // 背包容量为 absAdd，dp[0] = 1 表示和为0的子集（空集）有1种
        int[] dp = new int[absAdd + 1];
        dp[0] = 1;
        // 动态规划遍历：对每个数字，更新可能的和组合数 [3,5](@ref)
        for (int i = 0; i < nums.length; i++) {
            // 倒序遍历避免重复计算（每个数字只能使用一次）
            for (int j = absAdd; j >= nums[i]; j--) {
                // 状态转移：当前和 j 的方案数 = 不选当前数字的方案数 + 选当前数字的方案数（dp[j - nums[i]]）
                dp[j] += dp[j - nums[i]];
            }
        }
        // 调试输出，可删除（用于查看 dp 数组状态）
        System.out.println(Arrays.toString(dp));
        // 返回和为 add 的子集数量，即原问题中目标为 target 的表达式的数量 [3](@ref)
        return dp[absAdd];
    }
}
