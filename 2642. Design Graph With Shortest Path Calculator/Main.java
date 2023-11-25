class Graph {
    private Map<Integer, List<int[]>> adjacencyList;

    public Graph(int n, int[][] edges) {
        adjacencyList = new HashMap<>();
        
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int cost = edge[2];
            
            adjacencyList.computeIfAbsent(from, k -> new ArrayList<>()).add(new int[]{to, cost});
        }
    }
    
    public void addEdge(int[] edge) {
        int from = edge[0];
        int to = edge[1];
        int cost = edge[2];
        
        adjacencyList.computeIfAbsent(from, k -> new ArrayList<>()).add(new int[]{to, cost});
    }
    
    public int shortestPath(int node1, int node2) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        Map<Integer, Integer> distance = new HashMap<>();

        minHeap.offer(new int[]{node1, 0});
        distance.put(node1, 0);

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int currentNode = current[0];
            int currentCost = current[1];

            if (currentNode == node2) {
                return currentCost;
            }

            if (adjacencyList.containsKey(currentNode)) {
                for (int[] neighbor : adjacencyList.get(currentNode)) {
                    int neighborNode = neighbor[0];
                    int neighborCost = neighbor[1];
                    int newCost = currentCost + neighborCost;

                    if (!distance.containsKey(neighborNode) || newCost < distance.get(neighborNode)) {
                        distance.put(neighborNode, newCost);
                        minHeap.offer(new int[]{neighborNode, newCost});
                    }
                }
            }
        }

        return -1; // No path found
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */