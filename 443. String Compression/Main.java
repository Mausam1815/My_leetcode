class Solution {
    public int compress(char[] chars) {
        int writeIdx = 0; // Index to write compressed characters
        int count = 1; // Count of consecutive characters
        char currentChar = chars[0]; // Initialize with the first character
        
        for (int i = 1; i <= chars.length; i++) {
            if (i < chars.length && chars[i] == currentChar) {
                count++;
            } else {
                chars[writeIdx++] = currentChar; // Write the character
                
                if (count > 1) {
                    String countStr = Integer.toString(count);
                    for (char c : countStr.toCharArray()) {
                        chars[writeIdx++] = c; // Write the digit characters
                    }
                }
                
                if (i < chars.length) {
                    currentChar = chars[i];
                    count = 1;
                }
            }
        }
        
        return writeIdx; // Return the new length of the compressed array  
    }
}