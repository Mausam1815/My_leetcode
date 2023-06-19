class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        
        // Iterate through each number in the array
        for (int i = 0; i < nums.length; i++) {
            // Check for pairs starting from the current number
            for (int j = i + 1; j < nums.length; j++) {
                // If the sum of the current pair is equal to the target
                if ((nums[i] + nums[j]) == target) {
                    ans[0] = i; // Store the index of the first number
                    ans[1] = j; // Store the index of the second number
                }
            }
        }
        
        return ans; // Return the indices of the two numbers
    }
}
