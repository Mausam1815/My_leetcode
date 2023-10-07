class Solution {
    public String decodeAtIndex(String s, int k) {
        long decodedLength = 0;
        int i;
        
        // Calculate the length of the decoded string
        for (i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int repeat = c - '0';
                decodedLength *= repeat;
            } else {
                decodedLength++;
            }
            
            if (decodedLength >= k) {
                break;
            }
        }
        
        // Traverse the string in reverse to find the kth letter
        for (int j = i; j >= 0; j--) {
            char c = s.charAt(j);
            if (Character.isDigit(c)) {
                int repeat = c - '0';
                decodedLength /= repeat;
                k %= decodedLength;
            } else {
                if (k == 0 || k == decodedLength) {
                    return Character.toString(c);
                }
                decodedLength--;
            }
        }
        
        return "";
    }
}