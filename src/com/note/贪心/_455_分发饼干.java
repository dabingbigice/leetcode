package com.note.贪心;

import java.util.Arrays;

public class _455_分发饼干 {
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        //取小值
        int count = 0;
        int idx = 0;
        for (int j = 0; j < g.length; j++) {
            for (int i = idx; i < s.length; i++) {
                if (g[j] > s[i]) {
                    if (i == s.length - 1) return count;
                    continue;
                }
                idx = i;
                idx++;
                count++;
                break;
            }
        }
        return count;
    }

    public static int findContentChildren1(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int cnt = 0;
        for (int i = 0, j = 0; i < s.length && j < g.length; i++) {
            //拿饼干喂孩子
            if (s[i] >= g[j]) {
                cnt++;
                //喂饱了
                j++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        //   findContentChildren(new int[]{10, 9, 8, 7}, new int[]{5, 6, 7, 8});
        findContentChildren(new int[]{250, 490, 328, 149, 495, 325, 314, 360, 333, 418, 430, 458}, new int[]{376, 71, 228, 110, 215, 410, 363, 135, 508, 268, 494, 288, 24, 362, 20, 5, 247, 118, 152, 393, 458, 354, 201, 188, 425, 167, 220, 114, 148, 43, 403, 385, 512, 459, 71, 425, 142, 102, 361, 102, 232, 203, 25, 461, 298, 437, 252, 364, 171, 240, 233, 257, 305, 346, 307, 408, 163, 216, 243, 261, 137, 319, 33, 91, 116, 390, 139, 283, 174, 409, 191, 338, 123, 231, 101, 458, 497, 306, 400, 513, 175, 454, 273, 88, 169, 250, 196, 109, 505, 413, 371, 448, 12, 193, 396, 321, 466, 526, 276, 276, 198, 260, 131, 322, 65, 381, 20});
    }
}
