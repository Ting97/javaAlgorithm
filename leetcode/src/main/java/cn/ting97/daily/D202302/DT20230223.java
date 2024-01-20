package cn.ting97.daily.D202302;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname DT20230223
 * @Description <a href="https://leetcode.cn/problems/circular-permutation-in-binary-representation/">1238.循环码排列</a>
 * @Date 2023/2/23 08:38
 * @Author by chenlt
 */
public class DT20230223 {

    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            ret.add((i >> 1) ^ i ^ start);
        }
        return ret;
    }
}
