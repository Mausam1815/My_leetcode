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
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        return dfs(root, 0L, targetSum, map);
    }
    public int dfs(TreeNode node, long currSum, int tarSum, Map<Long, Integer> map) {
        if(node == null) {
            return 0;
        }
        currSum += node.val;
        int pathFromNode = map.getOrDefault(currSum - tarSum, 0);

        map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        pathFromNode += dfs(node.left, currSum, tarSum, map);
        pathFromNode += dfs(node.right, currSum, tarSum, map);
        map.put(currSum, map.get(currSum) -1);

        return pathFromNode;
    }
}