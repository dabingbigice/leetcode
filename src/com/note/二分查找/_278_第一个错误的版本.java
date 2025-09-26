package com.note.二分查找;

public class _278_第一个错误的版本 {
    public int firstBadVersion(int n) {
        int l = 0, r = n;
        //找最大值最小
        while (l < r) {
            // int mid = (l-r)/2+r;
            int mid = ((l - r) >> 1) + r;
//            if (isBadVersion(mid)) r = mid;
//            else l = mid + 1;
        }
        return l;

    }
}
