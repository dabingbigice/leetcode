package com.note.二分查找;

public class _704_二分查找 {
    /*
    * 示例 1:

    输入: nums = [-1,0,3,5,9,12], target = 9
    输出: 4
    解释: 9 出现在 nums 中并且下标为 4
    示例 2:

    输入: nums = [-1,0,3,5,9,12], target = 2
    输出: -1
    解释: 2 不存在 nums 中因此返回 -1
* */
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        //循环条件是 while (l < r)，这意味着当 l 和 r 相遇（即 l == r）时，循环结束。因此，在循环退出后，l 和 r 总是指向同一个索引位置。
        while (l < r) {
            int mid = (l + r) / 2;

            //mid不符合要求，right索引从mid开始
            if (nums[mid] >= target) r = mid;
                //mid不符合要求，left索引从mid-1开始
            else l = mid + 1;
        }
        //代码最后返回 r 而不是 l，但实际上，在循环结束时，l 和 r 的值是相等的，因此返回 r 或 l 在功能上是完全相同的。
        return nums[r] != target ? -1 : r;
    }

    public int search1(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        //循环条件是 while (l < r)，这意味着当 l 和 r 相遇（即 l == r）时，循环结束。因此，在循环退出后，l 和 r 总是指向同一个索引位置。
        while (l < r) {
            int mid = (l + r + 1) / 2;

            //mid不符合要求，right索引从mid开始
            if (nums[mid] <= target) l = mid;
                //mid不符合要求，left索引从mid-1开始
            else r = mid - 1;
        }
        //代码最后返回 r 而不是 l，但实际上，在循环结束时，l 和 r 的值是相等的，因此返回 r 或 l 在功能上是完全相同的。
        return nums[r] != target ? -1 : r;
    }
}
