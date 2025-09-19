package com.note.滑动窗口;

public class _1208_尽可能使字符串相等 {
    //子串转换，滑动窗口逐步增大
    public int equalSubstring(String s, String t, int maxCost) {
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        int maxLen = 0;
        for (int l = 0, r = 0; r < t.length(); r++) {
            //纳入新元素
            maxCost -= Math.abs(s1[r] - t1[r]);
            while (l <= r && maxCost < 0) {
                //如果纳入新元素过大，左指针收缩
                maxCost += Math.abs(s1[l] - t1[l]);
                l++;
            }

            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }


}
