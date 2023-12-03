class Solution {
    public int countCharacters(String[] words, String chars) {
        int result = 0;

        Map<Character, Integer> charFrequency = new HashMap<>();
        for (char c : chars.toCharArray()) {
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        }

        for (String word : words) {
            Map<Character, Integer> wordFrequency = new HashMap<>(charFrequency);

            boolean canForm = true;
            for (char c : word.toCharArray()) {
                if (!wordFrequency.containsKey(c) || wordFrequency.get(c) == 0) {
                    canForm = false;
                    break;
                }
                wordFrequency.put(c, wordFrequency.get(c) - 1);
            }

            if (canForm) {
                result += word.length();
            }
        }

        return result;
    }
}