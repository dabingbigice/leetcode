package com.note.滑动窗口;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _187_重复的DNA序列 {
    /*
    * DNA序列 由一系列核苷酸组成，缩写为 'A', 'C', 'G' 和 'T'.。
    例如，"ACGAATTCCG" 是一个 DNA序列 。
    在研究 DNA 时，识别 DNA 中的重复序列非常有用。
    给定一个表示 DNA序列 的字符串 s ，返回所有在 DNA 分子中出现不止一次的 长度为 10 的序列(子字符串)。你可以按 任意顺序 返回答案。

    示例 1：

    输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
    输出：["AAAAACCCCC","CCCCCAAAAA"]
    示例 2：

    输入：s = "AAAAAAAAAAAAA"
    输出：["AAAAAAAAAA"]
* */
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        Set<String> list = new HashSet<>();
        if (s.length() <= 10) return new ArrayList<>();
        //l与r的间距是10，一直向前移。找的是连续子串
        for (int l = 0, r = 9; r < s.length(); l++, r++) {
            String substring = s.substring(l, r + 1);
            if (l <= r && set.contains(substring)) {
                list.add(substring);
            }
            set.add(substring);
        }
        return new ArrayList<>(list);
    }
}
