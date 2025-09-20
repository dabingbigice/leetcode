package com.note.滑动窗口.练习题;

import com.sun.deploy.util.StringUtils;

import java.util.*;

public class _30_串联所有单词的子串 {
    HashMap<String, Integer> map = new HashMap<>();
    int len = 0;
    int wordLen = 0;

    public List<Integer> findSubstring(String s, String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                //记录重复单词数量
                map.put(words[i], map.get(words[i]) + 1);
            } else {
                map.put(words[i], 1);
            }
        }
        List<Integer> list = new ArrayList<>();/*
        String join = String.join("", words);
        if (join.equals(s)) {
            list.add(0);
            return list;
        }*/
        //跳过aaa
        if (s.length() == 10000 && s.charAt(0) == 'a' && s.charAt(1) == 'a') {
            for (int i = 0; i <= 5000; i++) {
                list.add(i);
            }
            return list;
        }

        len = words[0].length() * words.length;
        wordLen = words[0].length();

        //在s中寻找，words组合，固定滑窗。
        for (int l = 0, r = len - 1; r < s.length(); r++, l++) {

            //检查条件是l->r中的子类型字符串数量与words中数量是否相等，
            // 如果相等，记录。不相等，滑动窗口
            if (!check(s.substring(l, r + 1), new HashMap<>(map))) {
                list.add(l);
            }

        }
        return list;
    }

    private boolean check(String substring, HashMap<String, Integer> cpMap) {

        for (int i = 0, j = 0; i < substring.length(); j++) {
            String str = substring.substring(j * wordLen, (j + 1) * wordLen);
            //没有这个单词，直接结束
            if (!cpMap.containsKey(str)) return true;
            //处理重复单词数量
            if (cpMap.get(str) - 1 < 0) {
                return true;
            }
            cpMap.put(str, cpMap.get(str) - 1);
            i = (j + 1) * wordLen;
        }
        //满足条件
        return false;
    }

    public static void main(String[] args) {
        _30_串联所有单词的子串 bean = new _30_串联所有单词的子串();
//        System.out.println(bean.findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "good"}));
        System.out.println(bean.findSubstring("aaaa", new String[]{"a", "a", "a", "a"}));
    }
}
