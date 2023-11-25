class Solution {
    public int maxVowels(String s, int k) {
        int maxVowels = 0;
        int vowels = 0;
        char[] arr = {'a', 'e', 'i', 'o', 'u'};

        for(int i=0; i<k; i++) {
            if(isVowel(s.charAt(i), arr)) {
                vowels++;
            }
        }
        maxVowels = vowels;

        for(int i=k; i<s.length(); i++) {
            if(isVowel(s.charAt(i),arr)) {
                vowels++;
            }
            if(isVowel(s.charAt(i - k), arr)) {
                vowels--;
            }
            maxVowels = Math.max(maxVowels, vowels);
        }
        return maxVowels;
    }
    public boolean isVowel(char c, char[] arr) {
        for(char ch : arr) {
            if(c == ch) {
                return true;
            }
        }
        return false;
    }
}