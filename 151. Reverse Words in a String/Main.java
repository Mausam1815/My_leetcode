class Solution {
    public String reverseWords(String s) {
        // Step 1: Trim the input string to remove leading and trailing spaces
        s = s.trim();
        
        // Step 2: Split the string into an array of words using space as delimiter
        String[] words = s.split("\\s+");
        
        // Step 3: Reverse the order of words in the array
        int left = 0, right = words.length - 1;
        while (left < right) {
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }
        
        // Step 4: Join the words back together with a single space character
        return String.join(" ", words);
    }
}