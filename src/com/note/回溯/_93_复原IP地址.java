package com.note.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _93_复原IP地址 {
        List<String> res = new ArrayList<>();

        public List<String> restoreIpAddresses(String s) {
            LinkedList<String> path = new LinkedList<>();
            backTrace(0, s, path);
            return res;
        }

        public void backTrace(int startIndex, String s, LinkedList<String> path) {
            if (path.size() > 4) return; // 剪枝：如果已经超过4段，直接返回,
            // 这一组4个分段不满足，删除最后1段，最后1段增加1位
            if (startIndex == s.length() && path.size() == 4) {
                //4个分段，并且整个已经字符串遍历完成
                //如果没有遍历完成就有4个分段，那么肯定是错的。
                res.add(String.join(".", path)); // 找到一个有效IP
                return;
            }
            for (int i = startIndex; i < s.length(); i++) {
                //每次新增1位，然后判断是否满足条件。
                String segment = s.substring(startIndex, i + 1);
                //检查所有的可能
                if (!isValid(segment)) break; // 当前段无效，后面更长的也无效，直接跳出循环
                path.offerLast(segment);
                backTrace(i + 1, s, path); // 递归处理下一段
                path.removeLast(); // 回溯
            }
        }

        private boolean isValid(String s) {
            if (s.length() > 3) return false; // 长度超过3位，无效
            if (s.charAt(0) == '0') return s.length() == 1; // 处理前导零：如果是0开头，长度必须为1
            int num = Integer.parseInt(s);
            return num <= 255; // 检查数值范围
        }

    public static void main(String[] args) {
        new _93_复原IP地址().restoreIpAddresses("255255255255");
    }
}
