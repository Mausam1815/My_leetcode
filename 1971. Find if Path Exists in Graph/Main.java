class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        return dfs(graph, source, destination, visited);
    }
    public boolean dfs(List<List<Integer>> graph, int curr, int dest, boolean[] visited) {
        if(curr == dest) {
            return true;
        }

        visited[curr] = true;
        for(int nbr : graph.get(curr)) {
            if(!visited[nbr] && dfs(graph, nbr, dest, visited)){
                return true;
            }
        }

        return false;
    }
}