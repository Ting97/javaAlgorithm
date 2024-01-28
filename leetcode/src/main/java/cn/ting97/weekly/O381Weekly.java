package cn.ting97.weekly;

import java.util.Arrays;

/**
 * @Classname O381Weekly
 * @Description 第381周赛
 * @Date 2024/1/20 21:59
 * @Author by chenlt
 */
public class O381Weekly {

    /**
     * 输入单词需要的最少按键次数 I/II
     *
     * @param word 单词
     * @return 次数
     */
    public int minimumPushes(String word) {
        int[] nums = new int[26];
        for (int i = 0; i < word.length(); ++i) {
            nums[word.charAt(i) - 'a']++;
        }
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans += (i / 8 + 1) * nums[nums.length - i - 1];
        }
        return ans;
    }


}
