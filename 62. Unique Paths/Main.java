class Solution {
    public int uniquePaths(int m, int n) {
         // Calculate the binomial coefficient
        long paths = 1;
        for (int i = 1; i <= m - 1; i++) {
            paths *= (n - 1 + i);
            paths /= i;
        }
        return (int) paths;
    }
}