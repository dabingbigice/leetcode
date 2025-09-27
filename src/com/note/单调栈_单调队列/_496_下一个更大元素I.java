package com.note.单调栈_单调队列;

import java.util.HashMap;
import java.util.Stack;

public class _496_下一个更大元素I {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            boolean nextMax = false;
            boolean flag = false;
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    flag = true;
                }
                if (nums2[j] > nums1[i] && flag) {
                    res[i] = nums2[j];
                    nextMax = true;
                    break;
                }
            }
            if (!nextMax) {
                res[i] = -1;
            }
        }
        return res;
    }

    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //寻找nums2的下一个更大
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums1.length];
        //找nums2的最大索引
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                //找到下一个更大的了
                map.put(nums2[stack.pop()], nums2[i]);
            }
            stack.push(i);
        }
        //回到nums1组织结果
        for (int i = 0; i < nums1.length; i++) {
            if (map.get(nums1[i]) != null) {
                res[i] = map.get(nums1[i]);
            } else {
                res[i] = -1;
            }
        }
        return res;
    }
}
