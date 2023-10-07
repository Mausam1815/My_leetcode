class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int fullMask = (1 << n) - 1;
        int[][] dp = new int[n][fullMask + 1];
        
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][1 << i] = 0;
            queue.offer(new int[]{i, 1 << i});
        }
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int u = curr[0];
            int mask = curr[1];
            
            for (int v : graph[u]) {
                int nextMask = mask | (1 << v);
                if (dp[v][nextMask] > dp[u][mask] + 1) {
                    dp[v][nextMask] = dp[u][mask] + 1;
                    queue.offer(new int[]{v, nextMask});
                }
            }
        }
        
        int minPath = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minPath = Math.min(minPath, dp[i][fullMask]);
        }
        
        return minPath;
    }
}