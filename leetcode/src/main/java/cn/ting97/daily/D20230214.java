package cn.ting97.daily;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Classname D20230214
 * @Description <a href="https://leetcode.cn/problems/longest-well-performing-interval/">1124.表现良好的最长时间段</a>
 * @Date 2023/2/14 08:22
 * @Author by chenlt
 */
public class D20230214 {

    public int longestWPI(int[] hours) {
        int n = hours.length;
        int[] sum = new int[n + 1];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + (hours[i - 1] > 8 ? 1 : -1);
            if (stack.peek() != null && sum[i] < sum[stack.peek()]) {
                stack.push(i);
            }
        }
        int ans = 0;
        for (int i = n; i > 0; --i) {
            while (!stack.isEmpty() && sum[i] > sum[stack.peek()]) {
                ans = Math.max(ans, i - stack.pop());
            }
        }
        return ans;
    }
}
