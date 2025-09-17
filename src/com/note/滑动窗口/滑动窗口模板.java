package com.note.滑动窗口;

public class 滑动窗口模板 {
    public static void main(String[] args) {
        int[] nums = new int[1];
        int target = 0;
        int minLength = Integer.MIN_VALUE;
        for (int l = 0, r = 0, current = 0; r <nums.length; r++) {
            //右指针r：每次循环中，r向右移动一位，表示扩展窗口，将新元素 nums[r] 纳入窗口。
            // 因此，需要将 nums[r] 加到当前和 current 中（即 current += nums[r];）。
            current += nums[r];
            while (l <= r && current >= target) {
                if (current == target) {
                    minLength = Math.min(minLength, r - l + 1); // 计算窗口长度
                }
                //删除当前值，向右边滑动
                //左指针 l：当窗口内的和满足一定条件（如 current >= target）时，左指针
                //向右移动，表示收缩窗口，移除元素 nums[l]。
                //因此，需要从 current 中减去 nums[l]（即 current -= nums[l++];）。
                current -= nums[l++];
            }

        }
        // 修正3：处理找不到满足条件子数组的情况
        if (minLength == Integer.MAX_VALUE) {
            minLength = 0; // 没有找到符合条件的子数组
        }
    }
}
