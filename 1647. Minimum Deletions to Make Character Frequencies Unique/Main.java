class Solution {
    public int minDeletions(String s) {
        // Count the frequency of each character in the string
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Create a set to keep track of unique frequencies
        // We are interested in the frequencies only, not the characters
        // If a frequency is repeated, we need to delete one of them
        HashSet<Integer> uniqueFrequencies = new HashSet<>();

        int deletions = 0; // Initialize the count of deletions

        for (int freq : frequencyMap.values()) {
            while (uniqueFrequencies.contains(freq)) {
                freq--; // Decrement the frequency until it becomes unique
                deletions++; // Increment the count of deletions
            }
            if (freq > 0) {
                uniqueFrequencies.add(freq); // Add the unique frequency to the set
            }
        }

        return deletions;
    }
}