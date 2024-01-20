package cn.ting97.daily.D202302;

/**
 * @Classname D20230301
 * @Description <a href="https://leetcode.cn/problems/largest-local-values-in-a-matrix/submissions/">2373.矩阵中的局部最大值</a>
 * @Date 2023/3/1 23:39
 * @Author by chenlt
 */
public class D20230301 {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] res = new int[n - 2][n - 2];
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                // 枚举每个3x3矩阵的起点，搜索局部的3x3矩阵最大值
                res[i][j] = localMax(grid, i, j);
            }
        }
        return res;
    }

    private int localMax(int[][] grid, int left, int top) {
        int max = 0;
        for (int i = left; i < left + 3; i++) {
            for (int j = top; j < top + 3; j++) {
                max = Math.max(max, grid[i][j]);
            }
        }
        return max;
    }
}