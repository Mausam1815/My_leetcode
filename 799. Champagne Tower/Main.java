class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] glasses = new double[101][101]; // Maximum 100 rows
        
        // Pour champagne into the top glass
        glasses[0][0] = poured;
        
        // Simulate the flow of champagne
        for (int row = 0; row <= query_row; row++) {
            for (int glass = 0; glass <= row; glass++) {
                double overflow = (glasses[row][glass] - 1) / 2.0; // Overflow amount
                if (overflow > 0) {
                    glasses[row + 1][glass] += overflow; // Flow to the left glass below
                    glasses[row + 1][glass + 1] += overflow; // Flow to the right glass below
                }
            }
        }
        
        // Ensure the value is between 0 and 1
        return Math.min(1, glasses[query_row][query_glass]);
    }
}