package cn.ting97.weekly;

import java.util.*;

/**
 * @Classname T122Weekly
 * @Description 第122双周赛 结果 378/2547 前15%
 * @Date 2024/1/20 21:57
 * @Author by chenlt
 */
public class T122Weekly {


    /**
     * 除了第一个数之外，对剩下的数进行排序，取最小的两个数即可
     *
     * @param nums 数组
     * @return 最小花费
     */
    public int minimumCost(int[] nums) {
        int ans = nums[0];
        nums[0] = 51;
        Arrays.sort(nums);
        ans += nums[0] + nums[1];
        return ans;
    }

    /**
     * 将二进制一的个数一致的数组划分为一个区域
     * 对该区域进行排序
     * 对每个区域进行遍历，如果该区域的最小值小于上个区域的最小值，那么就不能形成有序数组
     * 都遍历完后，则表示可以形成
     *
     * @param nums 数组
     * @return 是否可以形成有序数组
     */
    public boolean canSortArray(int[] nums) {
        int length = nums.length;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < length; ) {
            int bt = Integer.bitCount(nums[i]);
            List<Integer> l = new ArrayList<>();

            while (i < length && Integer.bitCount(nums[i]) == bt) {
                l.add(nums[i++]);
            }

            l.sort(Comparator.comparingInt(a -> a));
            if (l.get(0) < max) {
                return false;
            }
            max = l.get(l.size() - 1);
        }
        return true;
    }

    /**
     * 排序
     * 遍历和最小数取模后可以获得比最小数小的数，那么就是1
     * 如果没有比最小数还小的数，看最小的数有多少个，然后除以2向上取整
     *
     * @param nums 数组
     * @return 返回使数组长度最小
     */
    public int minimumArrayLength(int[] nums) {
        Arrays.sort(nums);
        int t = nums[0];
        int count = 0;
        for (int num : nums) {
            if (t == num) {
                count++;
            } else if (num % t != 0) {
                return 1;
            }
        }
        return (count + 1) / 2;
    }

    // 暂时不会，后续看题解
    public long minimumCost(int[] nums, int k, int dist) {
        return -1;
    }


}
