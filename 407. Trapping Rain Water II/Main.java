class Solution {
    public int trapRainWater(int[][] heightMap) {
        int totRow = heightMap.length;
        int totCol = heightMap[0].length;

        PriorityQueue<Cell> minPQ = new PriorityQueue<>((a,b) -> a.height - b.height);
        boolean[][] vis = new boolean[totRow][totCol];

        for(int i=0; i<totRow; i++) {
            minPQ.offer(new Cell(i, 0, heightMap[i][0]));
            minPQ.offer(new Cell(i, totCol - 1, heightMap[i][totCol - 1]));
            vis[i][0] = true;
            vis[i][totCol - 1] = true;
        }

        for(int j=1; j<totCol; j++) {
            minPQ.offer(new Cell(0, j, heightMap[0][j]));
            minPQ.offer(new Cell(totRow - 1, j, heightMap[totRow - 1][j]));
            vis[0][j] = true;
            vis[totRow - 1][j] = true;
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int totalWater = 0;

        while(!minPQ.isEmpty()) {
            Cell cell = minPQ.poll();
            int row = cell.row;
            int col = cell.col;
            int height = cell.height;

            for(int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if(newRow > 0 && newRow < totRow && newCol > 0 && newCol < totCol && !vis[newRow][newCol]) {
                    int newHeight = heightMap[newRow][newCol];
                    if(newHeight < height) {
                        totalWater += height - newHeight;
                        minPQ.offer(new Cell(newRow, newCol, height));
                    }else {
                        minPQ.offer(new Cell(newRow, newCol, newHeight));
                    }
                    vis[newRow][newCol] = true;
                }
            }
        }
        return totalWater;
    }
}
class Cell {
    int row;
    int col;
    int height;

    public Cell(int row, int col, int height) {
        this.row = row;
        this.col = col;
        this.height = height;
    }
}