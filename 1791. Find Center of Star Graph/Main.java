class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length+1;
        int[] degrees = new int[n+1];

        for(int[] edge : edges) {
            degrees[edge[0]]++;
            degrees[edge[1]]++;
        }

        for(int i=0; i<=n; i++) {
            if(degrees[i] == n-1)
                return i;
        }
        return -1;
    }
}