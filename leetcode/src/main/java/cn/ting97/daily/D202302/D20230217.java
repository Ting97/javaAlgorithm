package cn.ting97.daily.D202302;

/**
 * @Classname D20230217
 * @Description <a href="https://leetcode.cn/problems/largest-1-bordered-square/">1139.最大的以1为边界的正方形</a>
 * @Date 2023/2/17 08:14
 * @Author by chenlt
 */
public class D20230217 {

    public int largest1BorderedSquare(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        // 计算前缀和
        int[][] rs = new int[n][m + 1];
        int[][] cs = new int[m][n + 1];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                rs[i][j + 1] = grid[i][j] + rs[i][j];
                cs[j][i + 1] = grid[i][j] + cs[j][i];
            }
        }

        for (int d = Math.min(m, n); d > 0; --d) {
            for (int i = 0; i <= n - d; ++i) {
                for (int j = 0; j <= m - d; ++j) {
                    if (rs[i][j + d] - rs[i][j] == d
                            && cs[j][i + d] - cs[j][i] == d
                            && rs[i + d - 1][j + d] - rs[i + d - 1][j] == d
                            && cs[j + d - 1][i + d] - cs[j + d - 1][i] == d) {
                        return d * d;
                    }
                }
            }
        }
        return 0;
    }
}
