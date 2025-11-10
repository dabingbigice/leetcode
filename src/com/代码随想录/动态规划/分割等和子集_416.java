package com.代码随想录.动态规划;

public class 分割等和子集_416 {
    public boolean canPartition(int[] nums) {
        // 计算数组所有元素的总和
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // 检查总和是否为奇数：如果是奇数则无法均分，直接返回false
        // 因为两个整数子集的和相等意味着总和必须是偶数
        if (sum % 2 != 0) return false;

        // 计算目标和（总和的一半），使用位运算右移1位等价于除以2
        int target = sum >> 1;

        // 创建动态规划数组dp，dp[j]表示容量为j的背包能装的最大价值
        // 在这个问题中，物品的重量和价值都是nums[i]，所以是经典的0-1背包问题[1,3](@ref)
        int dp[] = new int[target + 1];

        // 动态规划核心过程：遍历每个物品（数组元素）
        // 注意：这里从i=1开始，意味着nums[0]没有被正确处理，这是一个bug[1,3](@ref)
        for (int i = 1; i < nums.length; i++) {
            // 内层循环：从目标值target倒序遍历到当前物品的重量nums[i]
            // 倒序遍历确保每个物品只被使用一次（0-1背包特性）[3](@ref)
            // 每次遍历新元素时更新每一个容量不一样的背包
            for (int j = target; j >= nums[i]; j--) {
                // 状态转移方程：决定是否将当前物品放入背包,
                // 选择1：不放入当前物品，价值为dp[j]
                // 选择2：放入当前物品，价值为nums[i] + dp[j - nums[i]]
                // 取两者中的较大值[3,5](@ref)
                // 每次遍历新元素时更新所有背包
                dp[j] = Math.max(dp[j], nums[i] + dp[j - nums[i]]);
            }
        }
        // 检查背包能否恰好装下一半的容量：如果能，说明可以分割成两个等和子集
        return dp[target] == target;
    }

    public static void main(String[] args) {
        new 分割等和子集_416().canPartition(new int[]{1, 2, 3, 5});
    }
}
