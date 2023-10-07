class Solution {
    Map<String, PriorityQueue<String>> graph = new HashMap<>();
    List<String> itinerary = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        // Build a graph from the given tickets
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            graph.putIfAbsent(from, new PriorityQueue<>());
            graph.get(from).offer(to);
        }

        // Start the DFS from "JFK"
        dfs("JFK");

        // Reverse the result to get the correct itinerary
        Collections.reverse(itinerary);

        return itinerary;
    }

    private void dfs(String airport) {
        // If the airport has neighbors, visit them
        if (graph.containsKey(airport)) {
            PriorityQueue<String> neighbors = graph.get(airport);
            while (!neighbors.isEmpty()) {
                String nextAirport = neighbors.poll();
                dfs(nextAirport);
            }
        }
        // Add the current airport to the itinerary
        itinerary.add(airport);
    }
}
