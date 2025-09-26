package com.note.二分查找;

public class _367_有效的完全平方数 {
    public boolean isPerfectSquare(int num) {
        int l = 1, r = num / 2;
        while (l < r) {
            int mid = ((r - l) >> 1) + l;
            if ((long) mid * mid >= num) r = mid;
            else l = mid + 1;
        }
        return (long) l * l == num ? true : false;
    }
}
