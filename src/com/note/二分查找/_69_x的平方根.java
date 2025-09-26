package com.note.二分查找;

public class _69_x的平方根 {
    //尽可能的大
    public int mySqrt(int x) {
        int l = 0, r = x;
        while (l < r) {
            //大于最小值的最大值
            int mid =((l - r + 1)>>1) +r;
            if ((long) mid * mid <= x) l = mid ;
            else r = mid-1;
        }
        return l;
    }
}
