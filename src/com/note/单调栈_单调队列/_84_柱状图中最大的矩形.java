package com.note.单调栈_单调队列;

import java.util.Arrays;
import java.util.Stack;

public class _84_柱状图中最大的矩形 {
    //计算左边索引与右边索引然后再进行距离计算
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        //右边的更大
        int[] right = new int[n];
        Arrays.fill(right, n);
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() &&  heights[stack.peek()] > heights[i]) {
                Integer idx = stack.pop();
                //当前值是更大值
                right[idx] = i;
            }
            stack.push(i);
        }

        //左边的更小
        int[] left = new int[n];
        stack = new Stack<>();
        Arrays.fill(left, -1);
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                Integer idx = stack.pop();
                //当前值是更小值
                left[idx] = i;
            }
            stack.push(i);
        }
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            res = Math.max(res, (right[i] - left[i] - 1) * heights[i]);

        }
        return res;
    }

    public static void main(String[] args) {
        largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
    }
}
