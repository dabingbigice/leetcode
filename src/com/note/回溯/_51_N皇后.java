package com.note.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _51_N皇后 {
    List<List<String>> result = new ArrayList<>(); // 存储所有解
    boolean[] col; // 列占用状态
    boolean[] diag1; // 主对角线（左上到右下）占用状态
    boolean[] diag2; // 副对角线（右上到左下）占用状态
    char[][] board; // 棋盘

    public List<List<String>> solveNQueens(int n) {
        // 初始化棋盘
        board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        // 初始化状态数组
        col = new boolean[n];
        diag1 = new boolean[2 * n - 1]; // 主对角线数量：2*n-1
        diag2 = new boolean[2 * n - 1]; // 副对角线数量：2*n-1
        // 从第0行开始回溯求解
        backtrack(0, n);
        return result;
    }

    // 回溯函数
    private void backtrack(int row, int n) {
        // 终止条件：所有行处理完毕
        if (row == n) {
            result.add(generateSolution(board));
            return;
        }
        // 尝试当前行的所有列位置
        for (int j = 0; j < n; j++) {
            // 计算对角线索引
            int d1 = row - j + n - 1; // 主对角线索引（确保非负）
            int d2 = row + j; // 副对角线索引
            // 检查冲突：列、主对角线、副对角线
            if (!col[j] && !diag1[d1] && !diag2[d2]) {
                // 放置皇后并更新状态
                board[row][j] = 'Q';
                col[j] = true;
                diag1[d1] = true;
                diag2[d2] = true;

                // 递归处理下一行
                backtrack(row + 1, n);

                // 回溯：恢复状态
                board[row][j] = '.';
                col[j] = false;
                diag1[d1] = false;
                diag2[d2] = false;
            }
        }
    }

    // 生成解决方案：将字符数组转为字符串列表
    private List<String> generateSolution(char[][] board) {
        List<String> solution = new ArrayList<>();
        for (char[] row : board) {
            solution.add(new String(row));
        }
        return solution;
    }
}
