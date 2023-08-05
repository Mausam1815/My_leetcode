class Solution {
    public int findShortestCycle(int n, int[][] edges) {
        // Initialize distance matrix
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        // BFS to find shortest cycle
        int minCycle = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int[] dist = new int[n];
            Arrays.fill(dist, -1);
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            dist[i] = 0;
            while (!queue.isEmpty()) {
                int u = queue.remove();
                for (int v : adj.get(u)) {
                    if (dist[v] == -1) {
                        dist[v] = dist[u] + 1;
                        queue.add(v);
                    } else if (v != i && dist[v] >= dist[u]) {
                        minCycle = Math.min(minCycle, dist[u] + dist[v] + 1);
                    }
                }
            }
        }
        
        return (minCycle == Integer.MAX_VALUE) ? -1 : minCycle;
    }
}

        

