package cn.ting97.daily.D202302;

import java.util.*;

/**
 * @Classname D20230228
 * @Description <a href="https://leetcode.cn/problems/merge-similar-items/">2363.合并相似的物品</a>
 * @Date 2023/3/1 23:22
 * @Author by chenlt
 */
public class D20230228 {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] item : items1) {
            map.put(item[0], map.getOrDefault(item[0], 0) + item[1]);
        }
        for (int[] item : items2) {
            map.put(item[0], map.getOrDefault(item[0], 0) + item[1]);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans.add(new ArrayList<>(Arrays.asList(entry.getKey(), entry.getValue())));
        }
        return ans;
    }
}
