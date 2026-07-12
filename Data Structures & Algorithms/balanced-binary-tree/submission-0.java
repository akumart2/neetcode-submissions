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
    boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        isBalancedUtil(root);
        return isBalanced; 
    }

    private int isBalancedUtil(TreeNode root) {
        if (root == null) return 0;
        int left = isBalancedUtil(root.left);
        int right = isBalancedUtil(root.right);
        if (Math.abs(left - right) >= 2) isBalanced = false;
        return Math.max(left, right) + 1;
    }
}
