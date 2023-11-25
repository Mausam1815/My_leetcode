class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }

        Map<Integer, List<Integer>> stopToRoutesMap = new HashMap<>();

        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                stopToRoutesMap.computeIfAbsent(stop, k -> new ArrayList<>()).add(i);
            }
        }

        Set<Integer> visitedStops = new HashSet<>();
        Set<Integer> visitedRoutes = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        visitedStops.add(source);
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int currentStop = queue.poll();

                for (int route : stopToRoutesMap.getOrDefault(currentStop, Collections.emptyList())) {
                    if (visitedRoutes.contains(route)) {
                        continue;
                    }

                    visitedRoutes.add(route);

                    for (int nextStop : routes[route]) {
                        if (visitedStops.contains(nextStop)) {
                            continue;
                        }

                        if (nextStop == target) {
                            return steps + 1;
                        }

                        visitedStops.add(nextStop);
                        queue.offer(nextStop);
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}