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
    int ans = 0;
    public int averageOfSubtree(TreeNode root) {
        helper(root);
        return ans;
    }
    public int helper(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int sum = getSum(root);
        int count = getCount(root);
        int avg = sum / count;

        if(avg == root.val) {
            ans++;
        }

        return 1 + helper(root.left) + helper(root.right);
    }
    public int getSum(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return (root.val + getSum(root.left) + getSum(root.right));
    }
    public int getCount(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        return 1 + getCount(root.left) + getCount(root.right);
    }
}