class Solution {
    public String sortVowels(String s) {
        List<Character> vowels = new ArrayList<>();
        List<Integer> vowelIndices = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (isVowel(ch)) {
                vowels.add(ch);
                vowelIndices.add(i);
            }
        }

        // Sort the vowels
        Collections.sort(vowels);

        // Build the result string
        char[] result = new char[s.length()];
        Arrays.fill(result, ' '); // Initialize with space

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (isVowel(ch)) {
                // Place vowels in sorted order
                result[vowelIndices.remove(0)] = vowels.remove(0);
            } else {
                // Place consonants at their original indices
                result[i] = ch;
            }
        }
        return new String(result);
    }
    public boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) != -1;
    }
}