class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int provinceCount = 0;

        for(int i=0; i<n; i++) {
            if(!vis[i]) {
                dfs(i, vis, isConnected);
                provinceCount++;
            }
        }
        return provinceCount;
    }
    public void dfs(int city, boolean[] vis, int[][] isConnected) {
        vis[city] = true;

        for(int nbr = 0; nbr<isConnected.length; nbr++) {
            if(isConnected[city][nbr] == 1 && !vis[nbr]) {
                dfs(nbr, vis, isConnected);
            }
        }
    }
}