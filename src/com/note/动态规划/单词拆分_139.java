package com.note.动态规划;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class 单词拆分_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 将字典转换为HashSet，提高查询效率（O(1)时间复杂度）
        HashSet<String> words = new HashSet<>(wordDict);
        // 1. 定义dp数组：dp[i]表示字符串s的前i个字符（s[0:i)）能否被拆分成字典中的单词
        //    例如dp[4]=true表示s的前4个字符（如"leet"）可以被拆分
        boolean[] dp = new boolean[s.length() + 1];
        // 2. 初始化：空字符串默认可以被拆分（作为动态规划的基准状态）
        dp[0] = true;
        // 3. 动态规划核心逻辑：处理排列问题（顺序敏感），因此先遍历背包（字符串长度），再遍历分割点
        for (int i = 1; i <= s.length(); i++) {  // 遍历背包容量：i表示当前子串结束位置（长度）
            for (int j = 0; j < i; j++) {       // 遍历物品：j表示子串分割点（尝试所有可能的分割）
                // 关键条件：
                //   - dp[j]为true：表示s的前j个字符已可被拆分
                //   - words.contains(s.substring(j, i))：检查剩余子串s[j:i)是否在字典中
                // 若两者均满足，则说明s[0:i)整体可被拆分
                if (dp[j] && words.contains(s.substring(j, i))) {
                    dp[i] = true;  // 标记当前状态为true，并提前终止内层循环（优化效率）
                    break;         // 注意：此处break可优化，但原代码未添加，保留逻辑一致性
                }
            }
        }
        // 输出dp数组用于调试（可选）
        System.out.println(Arrays.toString(dp));
        // 返回结果：dp[s.length()]表示整个字符串s是否能被拆分
        return dp[s.length()];
    }
}
