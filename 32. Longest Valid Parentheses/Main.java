class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);  // Initialize with -1 to represent the base case

        int maxValidLength = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (currentChar == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i); // Reinitialize with the current index
                } else {
                    maxValidLength = Math.max(maxValidLength, i - stack.peek());
                }
            }
        }

        return maxValidLength;
    }
}