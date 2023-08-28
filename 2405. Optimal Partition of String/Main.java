public class Solution {
    public int partitionString(String s) {
        int n = s.length();
        int count = 0;  // Count of substrings
        HashSet<Character> uniqueChars = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (!uniqueChars.contains(s.charAt(i))) {
                uniqueChars.add(s.charAt(i));
            } else {
                count++;
                uniqueChars.clear();  // Clear the set for a new substring
                uniqueChars.add(s.charAt(i));
            }
        }

        if (!uniqueChars.isEmpty()) {
            count++;
        }

        return count;
    }
} {
    
}
