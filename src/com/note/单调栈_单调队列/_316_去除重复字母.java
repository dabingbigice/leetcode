package com.note.单调栈_单调队列;

import java.util.Collections;
import java.util.HashSet;
import java.util.Stack;

public class _316_去除重复字母 {
    /*给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
    示例 1：
    输入：s = "bcabc"
    输出："abc"

    示例 2：
    输入：s = "cbacdcbc"
    输出："acdb"
    遇到更小的需要判断剩余的是否含有已有的
    * */
    public static String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            while (!stack.isEmpty() && stack.peek() > s.charAt(i)) {
                //遇到更小的需要判断剩余的是否含有已有的
                String substring = s.substring(i);
                if (substring.contains(stack.peek().toString()) && !stack.contains(s.charAt(i))) {
                    //如果包含，弹出
                    stack.pop();
                } else {
                    break;
                }
            }
            if (!stack.contains(s.charAt(i))) stack.push(s.charAt(i));
        }
        String str = "";
        while (!stack.isEmpty()) str = stack.pop() + str;

        return str;
    }

    public static void main(String[] args) {
//        removeDuplicateLetters("bcabc");
        removeDuplicateLetters("cbacdcbc");
        removeDuplicateLetters("cbacdcbc");
    }
}
