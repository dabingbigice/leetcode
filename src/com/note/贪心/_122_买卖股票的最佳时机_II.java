package com.note.贪心;

import java.util.ArrayList;

public class _122_买卖股票的最佳时机_II {
    public static int maxProfit(int[] prices) {
        int rmb = 0;
        int l = 0, r = 0;
        for (; l < prices.length && r < prices.length - 1; ) {
            if (prices[r] >= prices[r + 1]) {
                //跌了
                int cnt = prices[r] - prices[l];
                if (cnt > 0) rmb += cnt;
                l = r;
                l++;
                r = l;
            } else {
                r++;
            }
        }
        int cnt = prices[r] - prices[l];
        if (cnt > 0) rmb += cnt;
        return rmb;
    }

    public static int maxProfit1(int[] prices) {
        int rmb = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int cnt = prices[i + 1] - prices[i];
            if (cnt > 0) {
                rmb+=cnt;
            }
        }

        return rmb;
    }

    public static void main(String[] args) {
//        maxProfit(new int[]{7, 1, 5, 3, 6, 4});
//        maxProfit(new int[]{1, 2, 3, 4, 5});
        maxProfit(new int[]{6, 1, 3, 2, 4, 7});
    }
}
