class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int count = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(vis[i][j] == false && grid[i][j] == '1') {
                    count++;
                    bfs(grid, vis, i, j);
                }
            }
        }
        return count;
    }
    public void bfs(char[][] grid, boolean[][] vis, int r, int c) {
        int n = grid.length;
        int m = grid[0].length;
        // mark
        vis[r][c] = true;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(r, c));
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Possible directions

        while(!q.isEmpty()) {
            int ro = q.peek().row;
            int co = q.peek().col;
            // remove
            q.remove();

            for (int[] direction : directions) {
                int newRow = ro + direction[0];
                int newCol = co + direction[1];
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == '1' && !vis[newRow][newCol]) {
                    vis[newRow][newCol] = true;
                    q.add(new Pair(newRow, newCol));
                }
            }
        }
    }
}
class Pair {
    int row;
    int col;
    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}