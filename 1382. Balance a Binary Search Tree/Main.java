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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> inorderValues = new ArrayList<>();
        collectInorderValues(root, inorderValues);
        
        return constructBalancedBST(inorderValues, 0, inorderValues.size() - 1);
    }
    
    private void collectInorderValues(TreeNode TreeNode, List<Integer> values) {
        if (TreeNode == null) {
            return;
        }
        
        collectInorderValues(TreeNode.left, values);
        values.add(TreeNode.val);
        collectInorderValues(TreeNode.right, values);
    }
    
    private TreeNode constructBalancedBST(List<Integer> values, int start, int end) {
        if (start > end) {
            return null;
        }
        
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(values.get(mid));
        root.left = constructBalancedBST(values, start, mid - 1);
        root.right = constructBalancedBST(values, mid + 1, end);
        
        return root;
    }
}