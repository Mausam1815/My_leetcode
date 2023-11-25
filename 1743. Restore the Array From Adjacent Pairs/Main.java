class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> adjMap = new HashMap<>();

        // Build the adjacency map
        for (int[] pair : adjacentPairs) {
            adjMap.computeIfAbsent(pair[0], k -> new ArrayList<>()).add(pair[1]);
            adjMap.computeIfAbsent(pair[1], k -> new ArrayList<>()).add(pair[0]);
        }

        // Find the start point
        int start = 0;
        for (Map.Entry<Integer, List<Integer>> entry : adjMap.entrySet()) {
            if (entry.getValue().size() == 1) {
                start = entry.getKey();
                break;
            }
        }

        // Reconstruct the original array
        int n = adjacentPairs.length + 1;
        int[] result = new int[n];
        result[0] = start;

        Set<Integer> visited = new HashSet<>();
        visited.add(start);

        for (int i = 1; i < n; i++) {
            List<Integer> neighbors = adjMap.get(result[i - 1]);
            for (int neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    result[i] = neighbor;
                    visited.add(neighbor);
                    break;
                }
            }
        }

        return result;
    }
}