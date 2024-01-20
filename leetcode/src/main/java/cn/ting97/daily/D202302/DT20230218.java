package cn.ting97.daily.D202302;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname DT20230218
 * @Description <a href="https://leetcode.cn/problems/find-positive-integer-solution-for-a-given-equation/">1237.找出给定方程的正整数解</a>
 * @Date 2023/2/19 12:37
 * @Author by chenlt
 */
public class DT20230218 {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<>();
        for (int x = 1, y = 1000; x <= 1000 && y >= 1; x++) {
            while (y >= 1 && customfunction.f(x, y) > z) {
                y--;
            }
            if (y >= 1 && customfunction.f(x, y) == z) {
                List<Integer> pair = new ArrayList<>();
                pair.add(x);
                pair.add(y);
                res.add(pair);
            }
        }
        return res;
    }

    public interface CustomFunction {
        // Returns f(x, y) for any given positive integers x and y.
        // Note that f(x, y) is increasing with respect to both x and y.
        // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
        int f(int x, int y);
    }
}
