package cn.ting97.daily.D202302;

/**
 * @Classname D20230220
 * @Description <a href="https://leetcode.cn/problems/best-poker-hand/">2347.最好的扑克手牌</a>
 * @Date 2023/2/20 00:14
 * @Author by chenlt
 */
public class D20230220 {
    public static final String WIM = "Flush";
    public static final String SECOND = "Three of a Kind";
    public static final String THIRD = "Pair";
    public static final String LOWER = "High Card";

    public String bestHand(int[] ranks, char[] suits) {
        int[] rank = new int[14];
        char c = suits[0];
        int t = 0;
        boolean third = false;
        boolean pair = false;
        for (int i = 0; i < ranks.length; ++i) {
            if (c == suits[i]) {
                t++;
            }
            rank[ranks[i]]++;
            if (rank[ranks[i]] == 3) {
                third = true;
            } else if (rank[ranks[i]] == 2) {
                pair = true;
            }
        }
        if (t == 5) {
            return WIM;
        } else if (third) {
            return SECOND;
        } else if (pair) {
            return THIRD;
        }
        return LOWER;
    }
}
