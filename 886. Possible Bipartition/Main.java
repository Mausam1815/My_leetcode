class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        // Create an adjacency list to represent the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        // Populate the adjacency list based on dislikes
        for (int[] dislike : dislikes) {
            int person1 = dislike[0];
            int person2 = dislike[1];
            graph.get(person1).add(person2);
            graph.get(person2).add(person1);
        }
        // Create an array to store the color (1 or 2) of each person
        int[] colors = new int[n + 1];
        Arrays.fill(colors, -1);
        // Iterate through each person and perform graph coloring
        for (int i = 1; i <= n; i++) {
            if (colors[i] == -1 && !isBipartite(i, 1, graph, colors)) {
                return false;
            }
        }
        return true;
    }
    // Helper function to check if the graph is bipartite
    public boolean isBipartite(int person, int color, List<List<Integer>> graph, int[] colors) {
        if (colors[person] != -1) {
            // If the current person has been colored, check if the color matches
            return colors[person] == color;
        }
        colors[person] = color; // Color the current person
        int oppositeColor = (color == 1) ? 2 : 1; // Determine the opposite color
        // Recursively check neighbors with the opposite color
        for (int neighbor : graph.get(person)) {
            if (!isBipartite(neighbor, oppositeColor, graph, colors)) {
                return false;
            }
        }
        return true; // The graph is bipartite
    }
}