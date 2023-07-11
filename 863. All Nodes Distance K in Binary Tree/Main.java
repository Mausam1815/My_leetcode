/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentMap = buildParentMap(root);

        List<Integer> result = new ArrayList<>();
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        visited.add(target);

        int distance = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();

            if(distance == k){
                for(int i=0; i<size; i++) {
                    result.add(queue.poll().val);
                }
                break;
            }

            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();

                if(node.left != null && !visited.contains(node.left)) {
                    queue.offer(node.left);
                    visited.add(node.left);
                }

                if (node.right != null && !visited.contains(node.right)) {
                    queue.offer(node.right);
                    visited.add(node.right);
                }

                TreeNode parent = parentMap.get(node);
                if (parent != null && !visited.contains(parent)) {
                    queue.offer(parent);
                    visited.add(parent);
                }
            }
            distance++;
        }
        return result;
    }
    private Map<TreeNode, TreeNode> buildParentMap(TreeNode root) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        buildParentMapHelper(root, null, parentMap);
        return parentMap;
    }

    private void buildParentMapHelper(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> parentMap) {
        if (node == null) {
            return;
        }

        parentMap.put(node, parent);
        buildParentMapHelper(node.left, node, parentMap);
        buildParentMapHelper(node.right, node, parentMap);
    }
}