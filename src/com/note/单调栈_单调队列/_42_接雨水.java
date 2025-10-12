package com.note.单调栈_单调队列;

import java.util.Stack;

public class _42_接雨水 {
    public static int trap(int[] height) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        int n = height.length;
        for (int i = 0; i < n; i++) {
            //水位
            int last = 0;
            //找到右边界 height[stack.peek()] <= height[i]
            while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
                //找到弹出左边界
                int top = stack.pop();

                //获取左右边界的宽，计算左边界与前一个元素的高度差计算一层水。这个公式在 while循环内，用于计算以弹出的栈顶元素 top为底部的“一层水”。
                ans += (i - top - 1) * (height[top] - last);
                //i是当前遍历的柱子，作为右边界。
                //stack.peek()（在弹出 top之后）是左边界。

                //(height[top] - last)：计算被夹在中间的元素高度。
                //height[top]是当前凹槽底部的高度。
                //last是之前已经计算过的水位高度。
                //两者之差 (height[top] - last)表示在 top这个底部高度上，
                // 从last水位线到 top柱子顶端这一层水的厚度。
                // 这相当于把凹槽的积水按高度分层，
                // 一层一层地计算。
                last = height[top];
            }
            //不满足 height[stack.peek()] <= height[i]条件时
            if (!stack.isEmpty()) {
                //这个公式在 while循环之后，用于处理栈未空时，当前柱子 i与栈顶元素之间剩余的一层水。
                ans += (i - stack.peek() - 1) * (height[i] - last);
            }
            stack.push(i);
        }
        return ans;
        //这个解法的精髓在于按层（水平）计算，而不是常见的按凹槽整体计算。
        // last变量就像一把尺子，精准地度量了哪些高度的水已经算过，哪些还没算，确保了计算既不重复也不遗漏。
    }

    public int trap1(int[] height) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        int n = height.length;
        for (int i = 0; i < n; i++) {
            int last = 0;
            //找右边界,=是为了计算深坑
            while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
                int top = stack.pop();
                ans += (i - top - 1) * (height[top] - last);
                //放置水位
                last = height[top];
            }

            if (!stack.isEmpty()) {
                ans += (i - stack.peek() - 1) * (height[i] - last);
            }
            //不是有边界，放入单调栈
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
//        trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
        trap(new int[]{2, 0, 1, 3});
    }
}
