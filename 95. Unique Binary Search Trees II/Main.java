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
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }
    public List<TreeNode> helper(int start, int end) {
        if(start > end) {
            List<TreeNode> base = new ArrayList<>();
            base.add(null);
            return base;
        }

        List<TreeNode> ans = new ArrayList<>();
        for(int i=start; i<=end; i++) {
            List<TreeNode> left = helper(start, i-1);
            List<TreeNode> right = helper(i+1, end);
            for(TreeNode lnode : left) {
                for(TreeNode rnode : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = lnode;
                    root.right = rnode;
                    ans.add(root);
                }
            }
        }
        return ans;
    }
}