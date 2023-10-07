class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length()); // Sort words by length
        Map<String, Integer> dp = new HashMap<>();
        int maxLength = 1;
        
        for (String word : words) {
            int currentMax = 1;
            for (int i = 0; i < word.length(); i++) {
                StringBuilder predecessor = new StringBuilder(word);
                predecessor.deleteCharAt(i);
                String predStr = predecessor.toString();
                
                if (dp.containsKey(predStr)) {
                    currentMax = Math.max(currentMax, dp.get(predStr) + 1);
                }
            }
            dp.put(word, currentMax);
            maxLength = Math.max(maxLength, currentMax);
        }
        
        return maxLength;
    }
}