package cn.ting97.daily.D202302;

import java.util.PriorityQueue;

/**
 * @Classname DT20230219
 * @Description <a href="https://leetcode.cn/problems/maximum-average-pass-ratio/">1792.最大平均通过率</a>
 * @Date 2023/2/19 12:37
 * @Author by chenlt
 */
public class DT20230219 {

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            long val1 = (long) (b[1] + 1) * b[1] * (a[1] - a[0]);
            long val2 = (long) (a[1] + 1) * a[1] * (b[1] - b[0]);
            if (val1 == val2) {
                return 0;
            }
            return val1 < val2 ? 1 : -1;
        });
        for (int[] c : classes) {
            pq.offer(new int[]{c[0], c[1]});
        }

        for (int i = 0; i < extraStudents; i++) {
            int[] arr = pq.poll();
            assert arr != null;
            int pass = arr[0], total = arr[1];
            pq.offer(new int[]{pass + 1, total + 1});
        }

        double res = 0;
        for (int i = 0; i < classes.length; i++) {
            int[] arr = pq.poll();
            assert arr != null;
            int pass = arr[0], total = arr[1];
            res += 1.0 * pass / total;
        }
        return res / classes.length;
    }

}
