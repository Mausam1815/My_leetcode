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
    public int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMaxLength = dfs(root.left, 1, true);  // Start with left direction
        int rightMaxLength = dfs(root.right, 1, false);  // Start with right direction
        
        return Math.max(leftMaxLength, rightMaxLength);
    }
    public int dfs(TreeNode node, int length, boolean isLeft) {
        if (node == null) {
            return 0;
        }
        
        int maxLength = length;
        
        if (isLeft) {
            maxLength = Math.max(maxLength, dfs(node.right, length + 1, false));
            maxLength = Math.max(maxLength, dfs(node.left, 1, true));
        } else {
            maxLength = Math.max(maxLength, dfs(node.left, length + 1, true));
            maxLength = Math.max(maxLength, dfs(node.right, 1, false));
        }
        
        return maxLength;
    }
}