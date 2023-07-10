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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // levelOrder will store node values level wise
        List<List<Integer>> levelOrder = new ArrayList<>();
        if(root == null){
            return levelOrder;
        }
        // que will store node of the same level
        Queue<TreeNode> que = new ArrayDeque<>();
        que.add(root);
        // add values to levelorder level wise
        while(que.size() != 0) {
            List<Integer> currLevel = new ArrayList<>();
            int count = que.size();
            for(int i=0; i<count; i++){
                TreeNode node = que.remove();
                currLevel.add(node.val);

                if(node.left != null){
                    que.add(node.left);
                }
                if(node.right != null){
                    que.add(node.right);
                }
            }
            levelOrder.add(currLevel);
        }
        return levelOrder;
    }
}