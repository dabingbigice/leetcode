package com.代码随想录.二刷;

public class _416分割等和子集 {
    public boolean canPartition(int[] nums) {
        //定义dpi，为容量为i的背包能装下多少
        //递推公式
        //初始化
        //遍历顺序
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //把所有和加起来，再/2，若背包能装满说明可行
        if (sum % 2 != 0) return false;
        int target = sum >> 1;
        int dp[] = new int[target + 1];
        for (int i = 1; i < nums.length; i++) {
            //j=背包重量，j--不断减少重量,且重量j要大于值nums[i]表示
            //nums[i]能装下，能继续计算
            for (int j = target; j >= nums[i]; j--) {
                //不装nums[i]和装nums[i]谁的价值更大
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[target] == target;
    }
}
