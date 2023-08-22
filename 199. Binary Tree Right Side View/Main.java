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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while(!que.isEmpty()) {
            int size = que.size();
            TreeNode lastNode = null;
            for(int i=0; i<size; i++) {
                TreeNode currNode = que.poll();
                lastNode = currNode;

                if(currNode.left != null) {
                    que.offer(currNode.left);
                }
                if(currNode.right != null) {
                    que.offer(currNode.right);
                }
            }
            ans.add(lastNode.val);
        }
        return ans;
    }
}