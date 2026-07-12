/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int count = 0;
    public int goodNodes(TreeNode root) {
        return goodNodes(root, root.val);
    }

    private int goodNodes(TreeNode root, int maxVal) {
        if (root == null) return 0;
        int result = (root.val >= maxVal) ? 1 : 0;
        maxVal = Math.max(maxVal, root.val);
        result += goodNodes(root.left, maxVal);
        result += goodNodes(root.right, maxVal);
        return result;
    }
}
