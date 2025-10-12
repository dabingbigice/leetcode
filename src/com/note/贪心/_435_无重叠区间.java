package com.note.贪心;

import java.util.Arrays;

public class _435_无重叠区间 {
    public int eraseOverlapIntervals(int[][] arr) {
        //排序
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);
        int pre = arr[0][1];
        //默认保留1个开头的区间
        int cnt = 1;
        for (int i = 1; i < arr.length; i++) {
            if (pre <= arr[i][0]) {
                cnt++;
                pre = arr[i][1];
            }
        }
        return arr.length - cnt;
    }
}
