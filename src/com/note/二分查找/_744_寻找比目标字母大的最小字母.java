package com.note.二分查找;

public class _744_寻找比目标字母大的最小字母 {
    public static char nextGreatestLetter(char[] letters, char target) {
        int l = 0, r = letters.length - 1;
        //寻找第一个满足条件的值
        while (l < r) {
            int mid = ((l + r) / 2);
//            ❌ 会停留在第一个等于 target 的字母，但题目要求的是“更大的”
//            if (letters[mid] >= target) r = mid;
//            ✅ 能正确跳过所有等于 target 的字母，找到下一个更大的
            if (letters[mid] > target) r = mid;
            else l = (mid + 1);
        }
        return letters[l];
    }

    public static void main(String[] args) {
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'f'));
        ;

    }
}
