package com.note.滑动窗口;

public class 滑动窗口模板 {
    public static void main(String[] args) {

        int[] nums = new int[1];
        int minLength = Integer.MIN_VALUE;

        for (int l = 0, r = 0, current = 0; r < nums.length; r++) {
            //右指针r：每次循环中，r向右移动一位，表示扩大窗口，将新元素 nums[r] 纳入窗口。
            // 因此，需要将新元素 nums[r] 加到当前和 current 中（即 current += nums[r];）。
            current += nums[r];
            while (l <= r && check()) {
                //满足条件check符合
                if (true) {
                    //业务逻辑
                    minLength = Math.min(minLength, r - l + 1); // 计算窗口长度
                }
                //删除当前值，左指针向右边滑动，缩短窗口
                current -= nums[l];
                l++;
            }
        }

    }

    private static boolean check() {
        return false;
    }
}
