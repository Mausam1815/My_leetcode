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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) {
            return false;
        }

        Queue<TreeNode> que = new ArrayDeque<>();
        que.add(root);

        while(que.size() > 0) {
            int count = que.size();
            boolean foundX = false;
            boolean foundY = false;
            TreeNode xParent = null;
            TreeNode yParent = null;

            for(int i=0; i<count; i++) {
                TreeNode curr = que.poll();
                if(curr.left != null) {
                    que.add(curr.left);
                    if(curr.left.val == x) {
                        foundX = true;
                        xParent = curr;
                    }else if(curr.left.val == y) {
                        foundY = true;
                        yParent = curr;
                    }
                }
                if(curr.right != null) {
                    que.add(curr.right);
                    if(curr.right.val == x) {
                        foundX = true;
                        xParent = curr;
                    }else if(curr.right.val == y) {
                        foundY = true;
                        yParent = curr;
                    }
                }
                if(foundX && foundY) {
                    return xParent != yParent;
                }
            }
            if(foundX || foundY) {
                return false;
            }
        }
        return false;
    }
}