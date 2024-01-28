package cn.ting97.weekly;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname O382Weekly
 * @Description TODO
 * @Date 2024/1/28 14:52
 * @Author by chenlt
 */
public class O382Weekly {

    public int countKeyChanges(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        System.out.println(chars);
        char c = chars[0];
        int ans = 0;

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != c) {
                ans++;
                c = chars[i];
            }
        }
        return ans;
    }

    public int maximumLength(int[] nums) {
        int ans = 1;
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Integer z = map.getOrDefault(1, 1);
        ans = z % 2 == 0 ? z - 1 : z;
        int pre = nums[0];
        for (int i = 0; i < nums.length - 1; ) {
            if (nums[i] == 1) {
                continue;
            }
            int t = 1;
            int k = nums[i];

            while (map.get(k) > 1 && map.getOrDefault(k * k, 0) > 0) {
                System.out.println("k = " + k);
                t += 2;
                k = k * k;
            }
            ans = Math.max(t, ans);
            while (i < nums.length - 1 && pre == nums[++i]) {
                System.out.println(i);
            }
            pre = nums[i - 1];
        }
        return ans;
    }

    public long flowerGame(int n, int m) {
        int o = m / 2, d = m / 2;
        if (m % 2 == 1) {
            d = m / 2 + 1;
        }
        long ans = 0;
        if (n % 2 == 1) {
            ans += (long) n / 2 * d + (long) (n / 2 + 1) * o;
        } else {
            ans += (long) n / 2 * d + (long) n / 2 * o;
        }
        return ans;
    }
}
