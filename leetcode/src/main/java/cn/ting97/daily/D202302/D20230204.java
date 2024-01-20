package cn.ting97.daily.D202302;

import java.util.Arrays;

/**
 * @Classname D20230204
 * @Description <a href="https://leetcode.cn/problems/maximum-number-of-consecutive-values-you-can-make/">1798.你能构造出连续值的最大数目</a>
 * @Date 2023/2/12 10:30
 * @Author by chenlt
 */
public class D20230204 {
    /**
     * 获取可以从0开始凑出的连续最大数
     *
     * @param coins 硬币面额
     * @return 最大数
     */
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int ans = 1;
        for (int c : coins) {
            if (ans >= c) {
                ans += c;
            } else {
                break;
            }
        }
        return ans;
    }

}
