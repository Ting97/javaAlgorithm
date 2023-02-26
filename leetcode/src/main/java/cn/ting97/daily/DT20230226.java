package cn.ting97.daily;

/**
 * @Classname DT20230236
 * @Description <a href="https://leetcode.cn/problems/maximum-score-words-formed-by-letters/">1255.得分最高的单词集合</a>
 * @Date 2023/2/26 23:03
 * @Author by chenlt
 */
public class DT20230226 {

    private String[] words;
    private int[] score;
    private final int[] left = new int[26];
    private int ans;

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        this.words = words;
        this.score = score;
        for (char c : letters) {
            ++left[c - 'a'];
        }
        dfs(words.length - 1, 0);
        return ans;
    }

    private void dfs(int i, int total) {
        if (i < 0) { // base case
            ans = Math.max(ans, total);
            return;
        }

        // 不选 words[i]
        dfs(i - 1, total);

        // 选 words[i]
        char[] s = words[i].toCharArray();
        boolean ok = true;
        for (char c : s) {
            if (left[c - 'a']-- == 0) {
                ok = false; // 剩余字母不足
            }
            total += score[c - 'a']; // 累加得分
        }

        if (ok) {
            dfs(i - 1, total);
        }

        // 恢复现场
        for (char c : s) {
            ++left[c - 'a'];
        }
    }
}
