class Solution {
    public int countNegatives(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        int row = 0;
        int col = m-1;

        while(row<n && col >=0) {
            if(grid[row][col] < 0) {
                count += (n - row);
                col--;
            }else {
                row++;
            }
        }
        return count;
    }
}