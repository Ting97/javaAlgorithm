package cn.ting97.daily.D202302;

/**
 * @Classname DT20230221
 * @Description <a href="https://leetcode.cn/problems/minimum-number-of-taps-to-open-to-water-a-garden/">1326.灌溉花园的最少水龙头数目</a>
 * @Date 2023/2/21 00:43
 * @Author by chenlt
 */
public class DT20230221 {
    public int minTaps(int n, int[] ranges) {
        int[] rightMost = new int[n + 1];
        for (int i = 0; i <= n; ++i) {
            int r = ranges[i];
            // 这样写可以在 i>r 时少写一个 max
            // 凭借这个优化，恭喜你超越了 100% 的用户
            // 说「超越」是因为原来的最快是 2ms，现在优化后是 1ms
            if (i > r) rightMost[i - r] = i + r; // 对于 i-r 来说，i+r 必然是它目前的最大值
            else rightMost[0] = Math.max(rightMost[0], i + r);
        }

        int ans = 0;
        int curRight = 0; // 已建造的桥的右端点
        int nextRight = 0; // 下一座桥的右端点的最大值
        for (int i = 0; i < n; ++i) { // 注意这里没有遍历到 n，因为它已经是终点了
            nextRight = Math.max(nextRight, rightMost[i]);
            if (i == curRight) { // 到达已建造的桥的右端点
                if (i == nextRight) return -1; // 无论怎么造桥，都无法从 i 到 i+1
                curRight = nextRight; // 造一座桥
                ++ans;
            }
        }
        return ans;
    }
}
