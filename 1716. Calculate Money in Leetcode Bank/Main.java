class Solution {
    public int totalMoney(int n) {
        int total = 0;
        int initial = 1;
        for(int i=0; i<n; i++) {
            total += initial + (i % 7);

            if((i + 1) % 7 == 0) {
                initial++;
            }
        }
        return total;
    }
}