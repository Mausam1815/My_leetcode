class Solution {
    private static final int MOD = 1_000_000_007;
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr); // Sort the array in ascending order.
        int n = arr.length;
        long[] dp = new long[n]; // To store the number of binary trees for each integer.

        for (int i = 0; i < n; i++) {
            dp[i] = 1; // Initialize the number of trees for each integer to 1 (the integer itself).
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    int complement = arr[i] / arr[j];
                    int complementIndex = Arrays.binarySearch(arr, complement);
                    if (complementIndex >= 0) {
                        dp[i] = (dp[i] + dp[j] * dp[complementIndex]) % MOD;
                    }
                }
            }
        }

        long totalTrees = 0;
        for (long count : dp) {
            totalTrees = (totalTrees + count) % MOD;
        }

        return (int) totalTrees;
    }
}