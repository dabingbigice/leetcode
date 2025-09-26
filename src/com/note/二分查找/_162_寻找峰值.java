package com.note.二分查找;

public class _162_寻找峰值 {
    public int findPeakElement(int[] nums) {
        int r = nums.length - 1, l = 0;
        while (l < r) {
            int mid = ((l - r) >> 1) + r;
            if (nums[mid] >= nums[mid + 1]) r = mid;
            else l = mid + 1;
        }
        return r;
    }
}
