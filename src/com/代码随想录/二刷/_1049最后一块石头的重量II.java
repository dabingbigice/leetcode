package com.代码随想录.二刷;

import java.util.Arrays;

public class _1049最后一块石头的重量II {
    public int lastStoneWeightII(int[] stones) {
        //定义dpi,递推公式，初始化，遍历顺序
        //把石头划分为两个集合，一半一半，最后粉碎
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
//        if (sum % 2 == 0) {
//            return 0;
//        }
        //target是背包容量，dp[i]为容量为i的背包最多装下多少
        int target = sum >> 1;
        int[] dp = new int[target + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        System.out.println(Arrays.toString(dp));
        return sum - dp[target] - dp[target];
    }
}
