package com.note.二分查找;

import java.lang.reflect.Array;
import java.util.Arrays;

public class _875_爱吃香蕉的珂珂 {
    public int minEatingSpeed(int[] piles, int h) {
        //piles.length <= h <= 109
        //1h最大吃的速度是1e9
        //寻找第一个满足条件的速度
        int l = 1, r = (int) 1e9;
        while (l < r) {
            int mid = ((l - r) >> 1) + r;
            if (check(mid,piles, h)) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    private boolean check(int x,int[] piles, int h) {
        int count = 0;
        for (int pile : piles) {
            count += pile / x;
            if (pile % x != 0) count++;
        }
        return count <= h;
    }
}
