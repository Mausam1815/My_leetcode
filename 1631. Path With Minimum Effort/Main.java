class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        
        // Binary search to find the minimum effort required
        int left = 0;
        int right = 1000000; // Max possible effort
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // Create a 2D array to mark visited cells during BFS
            boolean[][] visited = new boolean[rows][cols];
            
            // Perform BFS to check if a path exists with max difference <= mid
            if (canReachDestination(heights, rows, cols, 0, 0, mid, visited)) {
                // If path exists with max difference <= mid, try to reduce mid
                right = mid;
            } else {
                // If no path exists with max difference <= mid, increase mid
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    // Helper function to perform BFS to check if a path exists
    private boolean canReachDestination(int[][] heights, int rows, int cols, int x, int y, int maxDiff, boolean[][] visited) {
        if (x == rows - 1 && y == cols - 1) {
            return true; // Reached the destination
        }
        
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        
        visited[x][y] = true;
        
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            
            if (newX >= 0 && newX < rows && newY >= 0 && newY < cols
                && !visited[newX][newY] && Math.abs(heights[newX][newY] - heights[x][y]) <= maxDiff) {
                if (canReachDestination(heights, rows, cols, newX, newY, maxDiff, visited)) {
                    return true; // Continue BFS
                }
            }
        }
        
        return false; // No path found
    }
}
