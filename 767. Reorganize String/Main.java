class Solution {
    public String reorganizeString(String s) {
        int[] charCount = new int[26];
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }
        
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < 26; i++) {
            if (charCount[i] > 0) {
                maxHeap.offer(new int[]{i, charCount[i]});
            }
        }
        
        StringBuilder result = new StringBuilder();
        int[] prev = {-1, 0}; // Placeholder for the previous character
        
        while (!maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();
            result.append((char) (curr[0] + 'a'));
            curr[1]--;
            
            if (prev[1] > 0) {
                maxHeap.offer(prev);
            }
            
            prev = curr;
        }
        
        if (result.length() != s.length()) {
            return "";
        }
        
        return result.toString();
    }
}