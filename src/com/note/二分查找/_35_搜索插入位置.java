package com.note.二分查找;

public class _35_搜索插入位置 {
    public int searchInsert(int[] nums, int target) {
        //寻找第一个满足条件的元素
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] >= target) r = mid;
            else l = mid + 1;
        }
        return r;
    }
}
