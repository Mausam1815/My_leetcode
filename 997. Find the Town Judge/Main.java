class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trustsCount = new int[n+1];
        int[] trustedByCount = new int[n+1];

        for(int[] t : trust) {
            trustsCount[t[0]]++;
            trustedByCount[t[1]]++;
        }

        for(int i=1; i<=n; i++) {
            if(trustsCount[i] == 0 && trustedByCount[i] == n-1) {
                return i;
            }
        }
        return -1;
    }
}