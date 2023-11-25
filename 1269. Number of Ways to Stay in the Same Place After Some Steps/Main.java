class Solution {
    public int numWays(int steps, int arrLen) {
        int MOD = 1000000007;
    
    // Calculate the maximum possible range based on the number of steps
    int maxPos = Math.min(steps / 2, arrLen - 1);
    
    // Create a 2D array to store the number of ways to reach each position at each step
    int[][] dp = new int[steps + 1][maxPos + 1];
    dp[0][0] = 1;

    // Iterate through the steps and positions
    for (int i = 1; i <= steps; i++) {
        for (int j = 0; j <= maxPos; j++) {
            dp[i][j] = dp[i - 1][j];
            if (j > 0) {
                dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % MOD;
            }
            if (j < maxPos) {
                dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % MOD;
            }
        }
    }
    
    return dp[steps][0];
    }
}