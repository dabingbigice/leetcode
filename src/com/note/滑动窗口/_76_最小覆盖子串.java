package com.note.滑动窗口;

import java.util.*;

public class _76_最小覆盖子串 {
    /*给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
    注意：
    对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
    如果 s 中存在这样的子串，我们保证它是唯一的答案。
    示例 1：
    输入：s = "ADOBECODEBANC", t = "ABC"
    输出："BANC"
    解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
    示例 2：
    输入：s = "a", t = "a"
    输出："a"
    解释：整个字符串 s 是最小覆盖子串。
    示例 3:
    输入: s = "a", t = "aa"
    输出: ""
    解释: t 中两个字符 'a' 均应包含在 s 的子串中，
    因此没有符合条件的子字符串，返回空字符串。*/
    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        if (s.equals(t)) return s;
        String res = "";
        int minLen = Integer.MAX_VALUE;

        for (int l = 0, r = t.length() - 1; r < s.length(); r++) {
            //    输入：s = "ADOBECODEBANC", t = "ABC"
            //    输出："BANC"
            //    解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
            String current = s.substring(l, r + 1);
            while (l <= r && checkSubStr(current, t)) {
                //从左指针缩短区间
                if (current.length() < minLen) {
                    res = current;
                    minLen = current.length();
                }
                l++;
                current = s.substring(l, r + 1);
            }

        }
        return res;
    }

    private static boolean checkSubStr(String current, String t) {
        //统计s的子串字符数量
        short[] occ = new short[128];
        for (int i = 0; i < current.length(); i++) {
            occ[current.charAt(i)] += 1;
        }
        //进行t子串数量判断
        for (int i = 0; i < t.length(); i++) {
            occ[t.charAt(i)] -= 1;
            if (occ[t.charAt(i)] < 0) {
                //不满足,不是子序列
                return false;
            }
        }
        return true;
    }

    //统计t的，然后去滑动s的
    public static String minWindowOk(String s, String t) {
        if (s.length() < t.length()) return "";
        if (s.equals(t)) return s;
        int[] sCount = new int[128];
        int[] tCount = new int[128];
        //统计目标子串字符出现次数
        for (int j = 0; j < t.length(); j++) {
            tCount[t.charAt(j)] += 1;
        }
        char[] charArray = s.toCharArray();
        int minLen = Integer.MAX_VALUE, st = -1;
        for (int l = 0, r = 0; r < charArray.length; r++) {
            //纳入新元素
            sCount[charArray[r]] += 1;
            //检查子串是否符合标准，不符合则右指针移动
            while (l <= r && checkFlag(sCount, tCount)) {
                //不符合要求，删除老元素，收缩窗口
                if (r - l + 1 < minLen) {
                    //当前长度小于最小长度，更新
                    minLen = r - l + 1;
                    //子串起始位置
                    st = l;
                }
                //符合，子串左指针右移，【缩小窗口，寻找最小子串长度】
                sCount[charArray[l]]--;
                l++;
            }
        }
        return st == -1 ? "" : s.substring(st, st + minLen);
    }

    private static boolean checkFlag(int[] sCount, int[] tCount) {
        //检查子串是否符合标准
        for (int i = 0; i < sCount.length; i++) {
            if (sCount[i] < tCount[i]) {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
//        System.out.println(minWindow("cabwefgewcwaefgcf", "cae"));
        System.out.println(minWindowOk("bba", "ba"));
    }
}
