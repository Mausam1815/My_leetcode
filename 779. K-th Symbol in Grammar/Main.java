class Solution {
    public int kthGrammar(int n, int k) {
        // Base case
        if (n == 1) {
            return 0;
        }
        
        // Calculate the length of the previous row
        int lengthOfPrevRow = (int)Math.pow(2, n - 1);
        
        // If k is in the first half of the previous row, it will be the same as in the previous row
        if (k <= lengthOfPrevRow / 2) {
            return kthGrammar(n - 1, k);
        }
        // If k is in the second half of the previous row, it will be the opposite of the previous row
        else {
            return 1 - kthGrammar(n - 1, k - lengthOfPrevRow / 2);
        }
    }
}