class Solution {
    public int countHomogenous(String s) {
        int MOD = 1000000007;
        int currLen = 1;
        long ans = 0;
        for(int i=1; i<s.length(); i++) {
            if(s.charAt(i) == s.charAt(i - 1)) {
                currLen++;
            }else {
                ans += (currLen * (long) (currLen + 1) / 2) % MOD;
                currLen = 1;
            }
        }
        ans += (currLen * (long) (currLen + 1) / 2) % MOD;
        return (int) ans;
    }
}