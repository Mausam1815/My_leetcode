class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastOccurrence = new int[26];
        boolean[] visited = new boolean[26];
        Stack<Character> stack = new Stack<>();
        
        // Populate lastOccurrence with the last index of each character in s
        for (int i = 0; i < s.length(); i++) {
            lastOccurrence[s.charAt(i) - 'a'] = i;
        }
        
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            
            // If the current character is already in the stack, skip it
            if (visited[currentChar - 'a']) {
                continue;
            }
            
            // Pop characters from the stack if:
            // 1. They are greater than the current character
            // 2. They have occurrences later in the string
            while (!stack.isEmpty() && currentChar < stack.peek() && i < lastOccurrence[stack.peek() - 'a']) {
                visited[stack.pop() - 'a'] = false;
            }
            
            // Push the current character onto the stack
            stack.push(currentChar);
            visited[currentChar - 'a'] = true;
        }
        
        // Build the result string from the characters in the stack
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }
        
        return result.toString();
    }
}