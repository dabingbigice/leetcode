package com.note.单调栈_单调队列;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class _503_下一个更大元素II {

    public static int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res,-1);
        Stack<Integer> stack = new Stack<>();
        int num = nums.length;
        for (int i = 0; i < 2 * num; i++) {
            while (!stack.isEmpty() && nums[stack.peek() % num] < nums[i % num]) {
                int top = stack.pop();
                if (top < num) {
                    //找到下一个更小的，并且索引符合
                    res[top] = nums[i % num];
                }
            }
            stack.push(i);

        }
        return res;

    }

    public static void main(String[] args) {
        nextGreaterElements(new int[]{1,2,3,2,1});
    }
}
