class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Stack<Integer> st = new Stack<>();
        // loop to find next greater element
        for(int i=0; i<n*2; i++) {
            int num = nums[i%n];
            while(!st.isEmpty() && nums[st.peek()] < num) {
                ans[st.pop()] = num;
            }
            if(i < n) {
                st.push(i);
            }
        }
        return ans;
    }
}