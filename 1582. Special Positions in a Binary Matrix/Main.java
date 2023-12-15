class Solution {
    public int numSpecial(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int count = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(mat[i][j] == 1 && checkSpecial(mat, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }
    public boolean checkSpecial(int[][] mat, int row, int col) {
        for(int j=0; j<mat[0].length; j++) {
            if(j != col && mat[row][j] == 1) {
                return false;
            }
        }

        for(int i=0; i<mat.length; i++) {
            if(i != row && mat[i][col] == 1) {
                return false;
            }
        }
        return true;
    }
}