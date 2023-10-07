class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        Edge[] edges = new Edge[n * (n - 1) / 2];
        int k = 0;
        
        // Calculate all possible edges and their weights
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges[k++] = new Edge(i, j, dist);
            }
        }
        
        // Sort edges by weight
        Arrays.sort(edges, (a, b) -> Integer.compare(a.weight, b.weight));
        
        // Initialize parent array for Union-Find
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        int minCost = 0;
        int edgesAdded = 0;
        
        // Kruskal's algorithm
        for (Edge edge : edges) {
            int root1 = find(parent, edge.u);
            int root2 = find(parent, edge.v);
            if (root1 != root2) {
                parent[root1] = root2;
                minCost += edge.weight;
                edgesAdded++;
                if (edgesAdded == n - 1) {
                    break; // MST is complete
                }
            }
        }
        
        return minCost;
    }
    
    private int find(int[] parent, int node) {
        if (parent[node] != node) {
            parent[node] = find(parent, parent[node]);
        }
        return parent[node];
    }
    
    private static class Edge {
        int u, v, weight;
        
        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }
}
