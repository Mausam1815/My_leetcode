class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] cities = new int[n];
        boolean[][] connected = new boolean[n][n];

        for(int[] road : roads) {
            int c1 = road[0];
            int c2 = road[1];

            cities[c1]++;
            cities[c2]++;
            connected[c1][c2] = true;
            connected[c2][c1] = true;
        }

        int maxRank = 0;
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                int rank = cities[i] + cities[j] - (connected[i][j] ? 1 : 0);
                maxRank = Math.max(maxRank, rank);
            }
        }
        return maxRank;
    }
}