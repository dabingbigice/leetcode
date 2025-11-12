package com.代码随想录.动态规划;

import java.util.Arrays;

public class 不相交的线_1035 {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        // 方法功能：计算两个数组之间可以绘制的最大不相交连线数，等价于求两个数组的最长公共子序列的长度[3,5](@ref)。
        // 参数说明：
        //   nums1 - 第一个整数数组，代表水平线1上的数字序列
        //   nums2 - 第二个整数数组，代表水平线2上的数字序列
        // 返回值：最大连线数（即最长公共子序列的长度）
        // 定义DP数组：dp[i][j] 表示考虑 nums1 的前 i 个元素（索引0到i-1）和 nums2 的前 j 个元素（索引0到j-1）时，最长公共子序列的长度[1,5](@ref)。
        // 数组大小设为 (nums1.length + 1) x (nums2.length + 1)，以便处理空序列的情况（dp[0][j] 和 dp[i][0] 均初始化为0）[3](@ref)。
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        // 动态规划填表过程：遍历两个数组的所有可能子序列组合[1,5](@ref)
        for (int i = 1; i <= nums1.length; i++) {        // i 从1到nums1的长度，对应nums1的前i个元素
            for (int j = 1; j <= nums2.length; j++) {    // j 从1到nums2的长度，对应nums2的前j个元素
                // 检查当前元素是否相等：即nums1中第i-1个元素和nums2中第j-1个元素（因为数组索引从0开始）
                if (nums1[i - 1] == nums2[j - 1]) {
                    // 如果相等，则当前状态dp[i][j]可由子问题dp[i-1][j-1]转移而来，公共子序列长度加1[5](@ref)。
                    // 这表示在当前位置可以绘制一条连线，且不会与之前的连线相交[4](@ref)。
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 如果当前元素不相等，则无法以当前元素结尾形成公共子序列。
                    // 此时，最大长度取决于两个子问题的较大值：
                    //   dp[i-1][j]：忽略nums1的当前元素，只考虑nums1的前i-1个元素与nums2的前j个元素
                    //   dp[i][j-1]：忽略nums2的当前元素，只考虑nums1的前i个元素与nums2的前j-1个元素
                    // 这体现了最长公共子序列的“跳过”策略，确保序列顺序性[1,3,5](@ref)。
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        // 打印DP表最后一行（可选，用于调试或理解DP过程）
        // 这一行表示考虑整个nums1数组时，与nums2各个前缀子数组的公共子序列长度。
        System.out.println(Arrays.toString(dp[nums1.length]));
        // 返回最终结果：dp[nums1.length][nums2.length] 表示考虑两个数组全部元素时的最长公共子序列长度，即最大不相交连线数[1,5](@ref)。
        return dp[nums1.length][nums2.length];
    }
}
