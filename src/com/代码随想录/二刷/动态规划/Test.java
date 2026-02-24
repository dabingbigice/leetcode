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
        boolean[] dp = new boolean[s.length() + 1];
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

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 10000);
        dp[0] = 0;
        for (int i = 1; i * i <= n; i++) {
            int se = i * i;
            for (int j = se; j <= n; j++) {
                //当前的数-平方数 +1
                //如果当前的数-平方数后的那个temp值没有平方数，则会取到10000
                dp[j] = Math.min(dp[j], dp[j - se] + 1);
            }
        }
        return dp[n];
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 10000);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
        return dp[amount] == 10000 ? -1 : dp[amount];
    }

    public int combinationSum4(int[] nums, int target) {
        int dp[] = new int[target + 1];
        dp[0] = 1;
//        如果先遍历物品（nums[i]）再遍历背包容量（j），那么每个物品在计算过程中被固定的顺序所限制。
        for (int j = 1; j <= target; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= j)
                    //dp[0]是刚好减掉当前值为0,说明当前值满足要求
//                    j=1: dp[1] = dp[1] + dp[0] = 0+1 = 1(方式：1)
//                    不使用nums[i]有多少种方法(dp[j])+使用nums[i]有多少种方法(dp[j-nums[i])
                    dp[j] += dp[j - nums[i]];
            }
        }
        return dp[target];

    }

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
    //外层物品内层背包——>背包容量倒序遍历是为了保证物品i只被放入一次！——>物品只会被放入一背包 (01背包) 组合数
    //外层物品内层背包——>正序遍历物品i会被放入多次
    //外层背包，内层物品——>排列数

    public int maxProfit(int[] prices) {
        Integer minCost = Integer.MAX_VALUE;
        Integer profit = 0;
        for (int price : prices) {
            minCost = Math.min(price, minCost);
            profit = Math.max(profit, price - minCost);
        }
        return profit;
    }

    public int maxProfit1(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];//持有股票
        dp[0][1] = 0;//不持有股票
        for (int i = 1; i < prices.length; i++) {
            //持有最小股票价格
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            //卖出最大股票价格
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
        }
        return dp[prices.length - 1][1];
    }

//    public  int maxProfit(int[] prices) {
//        int[] dp = new int[prices.length];
//        if (prices.length < 2) return 0;
//        for (int i = 1; i < prices.length; i++) {
//            dp[i] = Math.max(dp[i - 1], dp[i - 1] + prices[i] - prices[i - 1]);
//        }
//        return dp[prices.length - 1];
//    }

    public int maxProfit2(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];//持有股票
        dp[0][1] = 0;//不持有股票
        for (int i = 1; i < prices.length; i++) {
            //持有最小股票价格
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            //卖出最大股票价格
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[prices.length - 1][1];
    }

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        if (nums.length < 2) return nums[0];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            //不偷，偷
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    public int rob2(int[] nums) {
        if (nums.length < 2) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        return Math.max(rob(Arrays.copyOfRange(nums, 0, nums.length - 1)), rob(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    public int maxProfit3(int[] prices, int fee) {
        int dp[][] = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], prices[i] + dp[i - 1][0] - fee);
        }
        return dp[dp.length - 1][1];
    }

    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
        }
        Arrays.sort(dp);
        return dp[nums.length - 1];
    }

    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            //连续递增，只要不成立，当前值就是默认值1。
            if (nums[i - 1] < nums[i]) {
                dp[i] = dp[i - 1] + 1;
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }

    public int maxSubArray(int[] nums) {
        if (nums.length < 2) return nums[0];
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
