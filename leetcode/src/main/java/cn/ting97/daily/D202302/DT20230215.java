package cn.ting97.daily.D202302;

/**
 * @Classname DT20230215
 * @Description <a href="https://leetcode.cn/problems/check-if-it-is-a-good-array/">1250.检查「好数组」</a>
 * @Date 2023/2/15 22:36
 * @Author by chenlt
 */
public class DT20230215 {
    public boolean isGoodArray(int[] nums) {
        int divisor = nums[0];
        for (int num : nums) {
            divisor = gcd(divisor, num);
            if (divisor == 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * 最大共约数
     *
     * @param a a
     * @param b b
     * @return 最大公约数
     */
    public int gcd(int a, int b) {
        while (a != 0) {
            int temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }
}
