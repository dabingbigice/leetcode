package com.note.单调栈_单调队列;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
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
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
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
            /*
            实际宽度 = (right[i] - 1) - (left[i] + 1) + 1 = right[i] - left[i] - 1
            最后的 +1是因为计算区间内元素个数时，通常用 右索引 - 左索引 + 1，但这里的左右索引是经过调整的。
            * */
            res = Math.max(res, (right[i] - left[i] - 1) * heights[i]);

        }
        return res;
    }

    //哨兵模式
    public int largestRectangleArea1(int[] heights) {
        int n = heights.length;
        // 创建新数组，首尾加入哨兵（高度为0）
        int[] newHeights = new int[n + 2];
        System.arraycopy(heights, 0, newHeights, 1, n);
        // 新数组的开头 newHeights[0] 和结尾 newHeights[n+1] 默认都是0

        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;

        // 遍历新数组，从第一个哨兵开始
        for (int i = 0; i < newHeights.length; i++) {
            // 当当前柱子高度小于栈顶柱子高度时，弹出栈顶并计算面积
            while (!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) {
                int height = newHeights[stack.pop()];
//                 [0, 2, 1, 5, 6, 2, 3, 0]
                // 此时的栈顶元素就是左边界，i就是右边界
                int width = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
    }
}
