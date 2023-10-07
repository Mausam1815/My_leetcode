class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        
        if (n < 3) {
            return false;
        }
        
        int[] minArray = new int[n];
        minArray[0] = nums[0];
        
        // Create an array to store the minimum element to the left of each index
        for (int i = 1; i < n; i++) {
            minArray[i] = Math.min(minArray[i - 1], nums[i]);
        }
        
        Stack<Integer> stack = new Stack<>();
        
        // Iterate through the array from right to left
        for (int j = n - 1; j >= 0; j--) {
            // If the current element is greater than the minimum element to its left
            if (nums[j] > minArray[j]) {
                // Check if there's a number in the stack that is less than nums[j]
                while (!stack.isEmpty() && stack.peek() <= minArray[j]) {
                    stack.pop();
                }
                // If we find such a number, return true
                if (!stack.isEmpty() && stack.peek() < nums[j]) {
                    return true;
                }
                // Otherwise, push nums[j] onto the stack
                stack.push(nums[j]);
            }
        }
        
        return false;
    }
}