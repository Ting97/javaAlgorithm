package cn.ting97.daily;

/**
 * @Classname D20230216
 * @Description <a href="https://leetcode.cn/problems/maximum-number-of-pairs-in-array/">2341.数组能形成多少数对</a>
 * @Date 2023/2/16 08:06
 * @Author by chenlt
 */
public class D20230216 {
    public int[] numberOfPairs(int[] nums) {
        int n = nums.length;
        int[] cnt = new int[101];
        for (int num : nums) {
            cnt[num]++;
        }
        int[] ans = new int[2];
        for (int j : cnt) {
            ans[1] += j % 2 == 1 ? 1 : 0;
            ans[0] += j / 2;
        }
        return ans;
    }
}
