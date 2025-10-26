package com.note.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _93_复原IP地址_1 {
    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        LinkedList<String> path = new LinkedList<>();
//            backTrace(0, s, path);
        dfs(0, s, path);
        return res;
    }

    void dfs(int startIndex, String s, List<String> path) {
        //大于4段了，失败
        if (path.size() > 4) return;
        if (s.length() == startIndex && path.size() == 4) {
            //字符串遍历完成，且只有4段
            res.add(String.join(".", path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            //截取片段,如果不满足会进行回溯，i会增大
            String seg = s.substring(startIndex, i + 1);
            if (!isVal(seg)) return;//结束本次不满足要求的回溯
            //满足继续回溯
            path.add(seg);
            dfs(i + 1, s, path);
            path.remove(path.size() - 1);
        }


    }

    private boolean isVal(String seg) {
        if (seg.length() > 3) return false;
        if (seg.charAt(0) == '0') return seg.length() == 1;//只有起始为0且长度为1才满足
        return Integer.parseInt(seg) <= 255;//该值要满足小于等于255
    }


    public static void main(String[] args) {
        new _93_复原IP地址_1().restoreIpAddresses("255255255255");
    }
}
