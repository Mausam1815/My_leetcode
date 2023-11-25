class Solution {
    public int findKOr(int[] nums, int k) {
        int n = nums.length;
        int result = 0;

        for (int bit = 0; bit <= 31; bit++) {
            int count = 0; // Count the number of elements with the bit set at position 'bit'.
            for (int num : nums) {
                if (((num >> bit) & 1) == 1) {
                    count++;
                }
            }

            if (count >= k) {
                // Set the bit in the result if it's set in at least 'k' elements of 'nums'.
                result |= (1 << bit);
            }
        }

        return result;
    }
}