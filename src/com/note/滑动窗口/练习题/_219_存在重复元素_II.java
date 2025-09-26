package com.note.滑动窗口.练习题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _219_存在重复元素_II {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        //索引是逐渐增大的，所以如果值相同但是条件不满足，需要记录索引值最大的那一个
        //这样下次他们的差值才会最小
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && Math.abs(map.get(nums[i]) - i) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }

        return false;
    }
}
