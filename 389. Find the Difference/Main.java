class Solution {
    public char findTheDifference(String s, String t) {
        // Initialize an array to store character frequencies
        int[] charFreq = new int[26];
        
        // Count character frequencies in string s
        for (char ch : s.toCharArray()) {
            charFreq[ch - 'a']++;
        }
        
        // Subtract character frequencies in string t
        for (char ch : t.toCharArray()) {
            charFreq[ch - 'a']--;
        }
        
        // Find the character with non-zero frequency in charFreq
        for (int i = 0; i < 26; i++) {
            if (charFreq[i] != 0) {
                return (char) ('a' + i);
            }
        }
        
        // This line should not be reached, as there is always one added letter
        return ' ';
    }
}