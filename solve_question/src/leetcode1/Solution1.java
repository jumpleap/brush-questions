package leetcode1;

import util.TreeNode;

import java.util.*;

/*
 * public class TreeNode {
 *   int val = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 *   public TreeNode(int val) {
 *     this.val = val;
 *   }
 * }
 */

public class Solution1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 思路分析: 递归
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     * @param root TreeNode类
     * @return int整型一维数组
     */
    public int[] postorderTraversal(TreeNode root) {
        // write code here
        List<Integer> list = new ArrayList<>();

        // 进行递归操作
        postOrder(root, list);
        int[] ans = new int[list.size()];

        // 数组赋值
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }

    private void postOrder(TreeNode root, List<Integer> list) {
        // 判空
        if (root == null) return;

        // 左右根
        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.val);
    }
}