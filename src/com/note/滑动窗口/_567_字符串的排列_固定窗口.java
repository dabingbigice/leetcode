package com.note.滑动窗口;

public class _567_字符串的排列_固定窗口 {

    public boolean checkInclusion(String s1, String s2) {

        if (s2.length() < s1.length()) return false;
        if (s2.equals(s1)) return true;
        //只需要滑动窗口内的字符数量相等，那么就一定存在排列
        short[] s1Count = new short[128];
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i)]++;
        }
        for (int l = 0, r = s1.length() - 1; r < s2.length(); r++, l++) {

            while (l <= r && check(s1Count, s2.substring(l, r + 1).toCharArray())) {
                return true;
            }
        }
        return false;
    }

    private boolean check(short[] s1Count, char[] charArray) {
        short[] s2Count = new short[128];
        for (int i = 0; i < charArray.length; i++) {
            s2Count[charArray[i]]++;
        }
        //如果传入的子串字符数量与s1不相同那么一定不存在排列
        for (int i = 0; i < s1Count.length; i++) {
            if (s1Count[i] < s2Count[i]) return false;
        }
        return true;
    }

    short[] s1Count = new short[128];
    short[] s2Count = new short[128];

    public boolean checkInclusion1(String s1, String s2) {
        if (s2.length() < s1.length()) return false;
        if (s2.equals(s1)) return true;
        //只需要滑动窗口内的字符数量相等，那么就一定存在排列

        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i)]++;
            s2Count[s2.charAt(i)]++;
        }

        for (int l = 0, r = s1.length(); r < s2.length(); r++, l++) {
            //执行最初构建的的检查
            while (l <= r && check1()) {
                return true;
            }
            s2Count[s2.charAt(l)]--;
            s2Count[s2.charAt(r + 1)]++;
        }
        //最后一次添加的检查
        if (check1()) return true;
        return false;
    }

    private boolean check1() {
        for (int i = 0; i < s1Count.length; i++) {
            if (s1Count[i] < s2Count[i]) return false;
        }
        return true;
    }

}
