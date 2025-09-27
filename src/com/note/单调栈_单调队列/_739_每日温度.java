package com.note.单调栈_单调队列;

import java.util.Stack;

public class _739_每日温度 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                //拿到了比现在更大的元素
                int top = stack.pop();
                //记录当前温度后更大的温度时间差有几天
                res[top] = i - top;
            }
            stack.push(i);
        }
        return res;
    }
}
