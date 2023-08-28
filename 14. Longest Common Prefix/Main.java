class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Handle the base case: If the input array is empty or contains no elements, return an empty string.
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Find the minimum length among all strings
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }

        // Initialize a StringBuilder to store the common prefix characters.
        StringBuilder commonPrefix = new StringBuilder();
        
        for (int i = 0; i < minLength; i++) {
            // Get the character at the current index from the first string.
            char currentChar = strs[0].charAt(i);
            
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != currentChar) {
                    // If characters mismatch, return the common prefix found so far.
                    return commonPrefix.toString();
                }
            }
            
            // Append the current character to the commonPrefix StringBuilder.
            commonPrefix.append(currentChar);
        }
        
        return commonPrefix.toString();
    }
}