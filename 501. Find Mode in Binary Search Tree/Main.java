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
    int currVal;
    int currCount = 0;
    int maxCount = 0;
    List<Integer> modes = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        inorderTraversal(root);
        int[] result = new int[modes.size()];
        for(int i=0; i<modes.size(); i++) {
            result[i] = modes.get(i);
        }
        return result;
    }
    public void inorderTraversal(TreeNode root) {
        if(root == null) {
            return;
        }
        inorderTraversal(root.left);
        if(root.val == currVal) {
            currCount++;
        }else {
            currVal = root.val;
            currCount = 1;
        }

        if(currCount == maxCount) {
            modes.add(currVal);
        }else if(currCount > maxCount) {
            modes.clear();
            modes.add(currVal);
            maxCount = currCount;
        }
        inorderTraversal(root.right);
    }
}