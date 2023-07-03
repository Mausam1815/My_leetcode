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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return construct(inorder, preorder, 0, inorder.length - 1, 0, preorder.length - 1);
    }
    public TreeNode construct(int[] inorder, int[] preorder, int inStart, int inEnd, int preStart, int preEnd){
        if(inStart > inEnd || preStart > preEnd){
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int cntEle = 0;
        int i = inStart;
        while(inorder[i] != root.val){
            i++;
            cntEle++;
        }

        root.left = construct(inorder, preorder, inStart, i - 1, preStart + 1, preStart + cntEle);
        root.right = construct(inorder, preorder, i + 1, inEnd, preStart + cntEle + 1, preEnd);
        return root;
    }
}