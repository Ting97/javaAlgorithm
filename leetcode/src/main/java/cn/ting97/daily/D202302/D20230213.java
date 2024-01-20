package cn.ting97.daily.D202302;

/**
 * @Classname D20230213
 * @Description <a href="https://leetcode.cn/problems/replace-the-substring-for-balanced-string/">1234.替换子串得到平衡字符串</a>
 * @Date 2023/2/13 07:55
 * @Author by chenlt
 */
public class D20230213 {

    public int balancedString(String s) {
        // 数组形式缓存
        int[] cnt = new int['Z'];
        char[] chars = s.toCharArray();
        // 统计字符数量
        for (char c : chars) {
            cnt[c]++;
        }
        int n = chars.length;
        int m = n / 4;
        // 当数量满足条件，返回0
        if (cnt['Q'] == m && cnt['W'] == m && cnt['E'] == m && cnt['R'] == m) {
            return 0;
        }
        // 从右端点开始，计算替换字串长度
        int ans = n, left = 0;
        for (int right = 0; right < n; ++right) {
            --cnt[chars[right]];
            // 缩小字串长度，只要满足可替换字串四种字符小于1/4值即可
            while (cnt['Q'] <= m && cnt['W'] <= m && cnt['E'] <= m && cnt['R'] <= m) {
                ans = Math.min(ans, right - left + 1);
                ++cnt[chars[left++]];
            }
        }
        return ans;
    }
}
