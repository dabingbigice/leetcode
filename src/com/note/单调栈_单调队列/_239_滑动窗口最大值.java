package com.note.单调栈_单调队列;

import java.lang.reflect.Array;
import java.util.*;

public class _239_滑动窗口最大值 {
    //超时
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) return nums;
        ArrayList<Integer> list = new ArrayList<>();
        for (int l = 0, r = k - 1; l < r && r < nums.length; l += 1, r += 1) {
            ArrayList<Integer> sort = new ArrayList<>();
            for (int i = l; i <= r; i++) {
                sort.add(nums[i]);
            }
            Collections.sort(sort);
            list.add(sort.get(sort.size() - 1));
        }
        Object[] array = list.toArray();
        int[] ints = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            ints[i] = (int) array[i];
        }

        return ints;
    }

    public static int[] maxSlidingWindow1(int[] nums, int k) {
        // 初始化结果数组，共有 n - k + 1 个窗口
        int[] res = new int[nums.length - k + 1];
        // 双端队列，用于存储元素的索引
        Deque<Integer> que = new LinkedList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) { // i 是当前右边界
            // 1. 检查队首是否已滑出窗口: 如果队首索引小于当前窗口的左边界 (i-k+1)，则弹出
            if (!que.isEmpty() && i - k + 1 > que.getFirst()) {
                que.pollFirst();
            }
            // 2. 维护队列的单调递减性: 从队尾开始，移除所有对应值小于当前值的索引
            while (!que.isEmpty() && nums[que.getLast()] < nums[i]) {
                que.pollLast();
            }
            // 3. 将当前元素的索引入队
            que.addLast(i);
            // 4. 如果当前窗口已经形成（i >= k-1），记录结果
            if (i >= k - 1) {
                // 队首索引对应的值就是当前窗口的最大值
                res[i - k + 1] = nums[que.getFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        maxSlidingWindow1(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
    }
}
