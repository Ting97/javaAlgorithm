package cn.ting97.daily;

/**
 * @Classname D20230227
 * @Description <a href="https://leetcode.cn/problems/decrease-elements-to-make-array-zigzag/">144.递减元素使数组呈锯齿状</a>
 * @Date 2023/2/27 07:41
 * @Author by chenlt
 */
public class D20230227 {
    public int movesToMakeZigzag(int[] nums) {
        int[] s = new int[2];
        for (int i = 0, n = nums.length; i < n; ++i) {
            int left = i > 0 ? nums[i - 1] : Integer.MAX_VALUE;
            int right = i < n - 1 ? nums[i + 1] : Integer.MAX_VALUE;
            s[i % 2] += Math.max(nums[i] - Math.min(left, right) + 1, 0);
        }
        return Math.min(s[0], s[1]);
    }
}
