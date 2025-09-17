package com.note.滑动窗口;

import com.sun.deploy.util.StringUtils;

import java.util.*;

public class _3_无重复字符的最长子串 {
    //给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
    /*
    * 示例 1:
        输入: s = "abcabcbb"
        输出: 3
        解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
        示例 2:

        输入: s = "bbbbb"
        输出: 1
        解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
        *
        示例 3:
        输入: s = "pwwkew"
        输出: 3
        解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
             请注意，你的答案必须是子 的长度，"pwke" 是一个子序列，不是子串。
        */
    //双指针
    public static int lengthOfLongestSubstring(String s) {
        //从头开始滑动窗口判断
        if (s.equals("")) return 0;
        String[] str = s.split("");
        int maxLen = 0;
        List<String> characters = new ArrayList<>();
        for (int l = 0, r = 0; r < str.length; r++) {
            //如果原来的窗口中有当前需要加入的元素
            while (l <= r && characters.contains(str[r])) {
                //记录最大子串长度
                //将左侧指针移动到第一次出现相同字符的位置
                l = l + 1 + characters.indexOf(str[r]);
                characters = characters.subList(characters.indexOf(str[r]) + 1, characters.size());
            }
            characters.add(str[r]);
            maxLen = Math.max(maxLen, characters.size());
        }

        return maxLen;
    }

    //hash适合判断是否存在重复元素，查询是o（c）
    public static int lengthOfLongestSubstringHash(String s) {
        //set只作为用来存储数据的容器，删除时可以指定元素
        Set<Character> str = new HashSet<>();
        int maxLen = 0;
        for (int l = 0, r = 0; r < s.length(); r++) {
            //判断set中是否存在子串重复的数据
            while (l <= r && str.contains(s.charAt(r))) {
                //如果待移除元素重复了，就一直移除，直到不存在为止
                str.remove(s.charAt(l++));
                //remove的是从左到右
                //left指针右移到重复的那个元素+1位置
            }
            //添加重复的那个新元素
            str.add(s.charAt(r));
            maxLen = Math.max(str.size(), maxLen);
        }
        return maxLen;
    }

    //使用boolean位判断
    public static int lengthOfLongestSubstringBit(String s) {
        boolean[] occ = new boolean[256];
        int maxLen = 0;
        for (int l = 0, r = 0; r < s.length(); r++) {
            while (l <= r && occ[s.charAt(r)]) {
                //如果存在则进行位元素删除
                occ[s.charAt(l++)] = false;
            }
            occ[s.charAt(r)] = true;
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int max = lengthOfLongestSubstring(" ");
        System.out.println(max);
    }
}
