package com.note.滑动窗口;

public class _209_长度最小的子数组 {
    //给定一个含有 n 个正整数的数组和一个正整数 target 。
    //找出该数组中满足其总和大于等于 target 的长度最小的子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
    // 并返回其长度。如果不存在符合条件的子数组，返回 0 。

    //关键特征，找子数组——>滑动窗口
    public int minSubArrayLen(int target, int[] nums) {
        //输入：target = 7, nums = [2,3,1,2,4,3]
        //输出：2
        //解释：子数组 [4,3] 是该条件下的长度最小的子数组。
        int minLength = Integer.MAX_VALUE;
        //r++ 滑动右边界
        for (int l = 0, r = 0, current = 0; r < nums.length; r++) {
            //窗口纳入新元素
            current += nums[r];
            while (l <= r && current >= target) {
                minLength = Math.min(r - l + 1, minLength);
                //剔除元素，收缩左边界,寻找最小的
                current -= nums[l++];
            }

        }
        // 修正3：处理找不到满足条件子数组的情况
        if (minLength == Integer.MAX_VALUE) {
            minLength = 0; // 没有找到符合条件的子数组
        }
        return minLength;
    }
}
