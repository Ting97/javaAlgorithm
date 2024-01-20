package cn.ting97.daily.D202302;

/**
 * @Classname D20230203
 * @Description <a href="https://leetcode.cn/problems/binary-tree-coloring-game/">1145.二叉树着色游戏</a>
 * @Date 2023/2/12 11:12
 * @Author by chenlt
 */
public class D20230203 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private int x, lsz, rsz;

    /**
     * 是否获胜
     *
     * @param root 根节点
     * @param n    树大小
     * @param x    先手染色节点
     * @return 后手是否可以获胜
     */
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        this.x = x;
        dfs(root);
        // 当父子树或者左右子树的大小超过整个树的大小的一半时，后手可以获胜
        return Math.max(Math.max(lsz, rsz), n - 1 - lsz - rsz) * 2 > n;
    }

    /**
     * 深度遍历，计算树的大小
     *
     * @param node 树根节点
     * @return 树的大小
     */
    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int ls = dfs(node.left);
        int rs = dfs(node.right);
        if (node.val == x) {
            lsz = ls;
            rsz = rs;
        }
        return ls + rs + 1;
    }
}
