package com.代码随想录.二刷.动态规划;

import java.util.Arrays;
import java.util.List;

public class Test {
    public int fib(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        if (n < 2) return dp[n];
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int climbStairs(int n) {
        if (n <= 2) return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        for (int i = 2; i <= cost.length; i++) {
            //（i-1层往上跳，i-2层往上跳），往上跳才支付
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }


    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        Arrays.fill(dp[0], 1);
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] != 1) dp[i][0] = 1;
            else break;
        }

        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] != 1) dp[0][i] = 1;
            else break;
        }

        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] != 1) dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

    public int numTrees(int n) {
        if (n <= 2) return n;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        //节点数
        for (int i = 3; i <= n; i++) {
            //左右子树，每个数都可能成为头节点
            for (int j = 1; j <= i; j++) {
                // 累加：以j为根时，所有左右子树组合的可能性
                dp[i] += dp[j - 1] * dp[i - j];
                //当两个选择或事件相互独立时，它们同时发生的总方案数是各自方案数的乘积。
            }
        }
        return dp[n];
    }

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                //拆分为2个或者3个及以上
                dp[i] = Math.max(dp[i], Math.max((i - j) * j, dp[i - j] * j));
            }
        }
        return dp[n];
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        int target = sum >> 1;
        int[] dp = new int[target + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
                if (dp[i] == target) return true;
            }
        }
        return target == dp[target];
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < strs.length; i++) {
            String tmp = strs[i];
            int x = 0;
            int y = 0;
            for (int j = 0; j < tmp.length(); j++) {
                if (tmp.charAt(j) == '0') x++;
                else y++;
            }
            for (int j = m; j >= x; j--) {
                for (int k = n; k >= y; k--) {
                    //背包重后往前遍历
                    dp[j][k] = Math.max(dp[j][k], dp[j - x][k - y] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int target = sum >> 1;
        int[] dp = new int[target + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - dp[target] * 2;
    }

    //完全背包
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() +1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (wordDict.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }

}
