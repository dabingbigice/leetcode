package com.note.二分查找;

public class _69_x的平方根 {
    //尽可能的大
    public int mySqrt(int x) {
        int l = 0, r = x;
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if ((long) mid * mid < x) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}
