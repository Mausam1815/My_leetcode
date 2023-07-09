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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(key < root.val) {
            // if key is smaller than root value 
            // check and update left subtree
            root.left = deleteNode(root.left, key);
        }else if(key > root.val){
            // if key is greater than root value
            // check and update right subtree 
            root.right = deleteNode(root.right, key);
        }else {
            // this is the node we have to delete
            // if node have any one chile
            if(root.right == null){
                return root.left;
            }else if(root.left == null){
                return root.right;
            }
            // if node have both child
            // find minimum of its subtree
            // replace node with it
            root.val = minValue(root.right);
            // update nodes
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }
    public int minValue(TreeNode root){
        if(root.left == null){
            return root.val;
        }
        return minValue(root.left);
    }
}