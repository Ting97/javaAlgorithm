package cn.ting97.daily;

import java.util.Arrays;

/**
 * @Classname D20230222
 * @Description <a href="https://leetcode.cn/problems/stone-game-ii/">1140.石子游戏II</a>
 * @Date 2023/2/22 20:34
 * @Author by chenlt
 */
public class D20230222 {
    int[] s;
    int[][] cache;

    public int stoneGameII(int[] piles) {
        s = piles;
        int n = s.length;
        for (int i = n - 2; i >= 0; --i) {
            s[i] += s[i + 1]; // 后缀和
        }

        cache = new int[n - 1][(n + 1) / 4 + 1];
        for (int i = 0; i < n - 1; i++) {
            Arrays.fill(cache[i], -1); // -1 表示没有访问过
        }
        return dfs(0, 1);
    }

    private int dfs(int i, int m) {
        if (i + m * 2 >= s.length) {
            return s[i];
        }
        if (cache[i][m] != -1) {
            return cache[i][m];
        }
        int mn = Integer.MAX_VALUE;
        for (int x = 1; x <= m * 2; ++x) {
            mn = Math.min(mn, dfs(i + x, Math.max(m, x)));
        }
        return cache[i][m] = s[i] - mn;
    }
}
