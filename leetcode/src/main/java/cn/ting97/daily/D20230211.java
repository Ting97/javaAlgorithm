package cn.ting97.daily;

import java.util.Arrays;

/**
 * @Classname D20230211
 * @Description <a href="https://leetcode.cn/problems/minimum-amount-of-time-to-fill-cups/">2335.装满杯子需要的最短总时长</a>
 * @Date 2023/2/11 12:27
 * @Author by chenlt
 */
public class D20230211 {
    /**
     * 排序+贪心
     *
     * @param amount 总数
     * @return 时间
     */
    public int fillCups1(int[] amount) {
        Arrays.sort(amount);
        if (amount[2] > amount[1] + amount[0]) {
            return amount[2];
        }
        return (amount[0] + amount[1] + amount[2] + 1) / 2;
    }

    /**
     * 贪心+比较
     *
     * @param amount 总数
     * @return 时间
     */
    public int fillCups2(int[] amount) {
        if (amount[0] >= (amount[1] + amount[2])) return amount[0];
        if (amount[1] >= (amount[0] + amount[2])) return amount[1];
        if (amount[2] >= (amount[1] + amount[0])) return amount[2];
        return (amount[0] + amount[1] + amount[2] + 1) / 2;
    }

    public static void main(String[] args) {
        D20230211 d20230211 = new D20230211();
        System.out.println("d20230211.fillCups1(new int[]{1, 2, 3}) = " + d20230211.fillCups1(new int[]{1, 2, 3}));
        System.out.println("d20230211.fillCups2(new int[]{1, 2, 3}) = " + d20230211.fillCups2(new int[]{1, 2, 3}));
    }
}
