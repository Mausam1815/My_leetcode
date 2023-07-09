class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(); // map for next greater element
        Stack<Integer> stack = new Stack<>();
        for (int num : nums2) {
            // Pop elements from stack and update map with next greater element
            while (!stack.empty() && stack.peek() < num) { 
                map.put(stack.pop(), num);
            }
            stack.push(num); // Push current element onto stack
        }
        // Check if each element in nums1 has a next greater element in map
        for (int i = 0; i < nums1.length; i++) { 
            // Update element in nums1 with next greater element or -1
            nums1[i] = map.containsKey(nums1[i]) ? map.get(nums1[i]) : -1; 
        }
        return nums1;
    }
}