package com.note.二分查找;

public class _34_在排序数组中查找元素的第一个和最后一个位置 {
    public static int[] searchRange(int[] nums, int target) {
        if(nums.length==1 && target==nums[0]) return new int[]{0,0};
        if(nums.length<2) return new int[]{-1,-1};
        int[] index = new int[2];
        int l = 0, r = nums.length-1;

        //找最先满足条件的
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] >= target) r = mid;
            else l = mid + 1;
        }
        index[0] = nums[l] == target ? r : -1;
        l = 0;
        r = nums.length-1;

        //最后一个满足条件的
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (nums[mid] <= target) l = mid;
            else r = mid - 1;
        }
        index[1] = nums[l] == target ? r : -1;
        return index;
    }

    public static void main(String[] args) {
        searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);

    }
}
