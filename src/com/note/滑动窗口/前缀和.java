package com.note.滑动窗口;

import java.util.Arrays;

public class 前缀和 {
    public static void intervals(int[] arr, int[] target, int i, int j) {
        System.out.println(target[j + 1] - arr[i]);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        //记录前缀和
        int[] target = new int[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            target[i + 1] = target[i] + arr[i];
        }
        System.out.println(Arrays.toString(target));
        intervals(arr, target, 0, 3);
    }
}
