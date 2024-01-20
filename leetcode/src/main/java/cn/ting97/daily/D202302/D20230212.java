package cn.ting97.daily.D202302;

/**
 * @Classname D20230212
 * @Description <a href="https://leetcode.cn/problems/alphabet-board-path/">1138.字母板上的路径</a>
 * @Date 2023/2/12 10:12
 * @Author by chenlt
 */
public class D20230212 {
    /**
     * 获取目标得到目标字符串的路径，模拟
     * 1. 获取当前目标字符的位置
     * 2. 目标字符位置和当前字符位置走即可
     *
     * @param target 目标字符串
     * @return 路径
     */
    public String alphabetBoardPath(String target) {

        int curX = 0, curY = 0, tarX, tarY;

        char[] chars = target.toCharArray();
        StringBuilder ans = new StringBuilder();
        for (char c : chars) {
            tarX = (c - 'a') / 5;
            tarY = (c - 'a') % 5;
            if (curX > tarX) {
                ans.append("U".repeat(curX - tarX));
            }
            if (curY > tarY) {
                ans.append("L".repeat(curY - tarY));
            }
            if (curX < tarX) {
                ans.append("D".repeat(tarX - curX));
            }
            if (curY < tarY) {
                ans.append("R".repeat(tarY - curY));
            }
            ans.append("!");
            curX = tarX;
            curY = tarY;
        }
        return ans.toString();
    }


}
