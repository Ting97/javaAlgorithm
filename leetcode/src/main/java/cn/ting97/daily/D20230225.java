package cn.ting97.daily;

/**
 * @Classname D20230225
 * @Description <a href="https://leetcode.cn/problems/minimum-swaps-to-make-strings-equal/">1247.交换字符使得字符串相同</a>
 * @Date 2023/2/26 23:12
 * @Author by chenlt
 */
public class D20230225 {
    public int minimumSwap(String s1, String s2) {
        int[] cnt = new int[2];
        for (int i = 0, n = s1.length(); i < n; ++i)
            if (s1.charAt(i) != s2.charAt(i))
                ++cnt[s1.charAt(i) % 2]; // x 和 y ASCII 值的二进制最低位不同
        int d = cnt[0] + cnt[1];
        return d % 2 != 0 ? -1 : d / 2 + cnt[0] % 2;
    }
}
