package com.note.二分查找;

public class _69_x的平方根 {
    //尽可能的大
    public int mySqrt(int x) {
        int l = 0, r = x;
        while (l < r) {
            //小于目标值的最大值
            int mid = ((l - r + 1) >> 1) + r;
            if ((long) mid * mid <= x) r = mid;
            else l = mid - 1;
        }
        return r;
    }

    public int mySqrt1(int x) {
        int l = 0, r = x;
        while (l < r) {
            int mid = (l - r) >> 1 + r;
            if ((long) mid * mid >= x) r = mid;
            else l = mid + 1;
        }
        return r;
    }

    public int mySqrt3(int x) {
        int l = 0, r = x;
        while (l < r) {
            int mid = (l + r) >> 1;
            if ((long) mid * mid >= x) r = mid;
            else l = mid + 1;
        }
        return (long) r * r == x ? r : r - 1;
    }
}
