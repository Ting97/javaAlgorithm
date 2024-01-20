package cn.ting97.daily.D202302;

import java.util.Arrays;

/**
 * @Classname D20230224
 * @Description <a href="https://leetcode.cn/problems/make-array-zero-by-subtracting-equal-amounts/">2357.使数组中所有元素都等于零</a>
 * @Date 2023/2/24 00:44
 * @Author by chenlt
 */
public class D20230224 {

    public int minimumOperations(int[] nums) {
        return (int) Arrays.stream(nums).filter(i -> i != 0).distinct().count();
    }
}
