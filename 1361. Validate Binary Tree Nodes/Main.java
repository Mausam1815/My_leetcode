class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        // find all the unique node
        Set<Integer> uniNodes = new HashSet<>();
        for(int i=0; i<n; i++) {
            uniNodes.add(leftChild[i]);
            uniNodes.add(rightChild[i]);
        }

        // find root node
        int root = -1;
        for(int i=0; i<n; i++) {
            if(!uniNodes.contains(i)) {
                root = i;
                break;
            }
        }
        if(root == -1) {
            return false;
        }

        Set<Integer> visSet = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()) {
            int len = q.size();
            while(len > 0) {
                int node = q.poll();
                if(visSet.contains(node)) {
                    return false;
                }
                visSet.add(node);
                if(leftChild[node] != -1) {
                    q.offer(leftChild[node]);
                }
                if(rightChild[node] != -1) {
                    q.offer(rightChild[node]);
                }
                len--;
            }
        }
        return visSet.size() == n;
    }
}