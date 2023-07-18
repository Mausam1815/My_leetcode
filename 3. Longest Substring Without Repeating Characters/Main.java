class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int maxLen = Integer.MIN_VALUE;
        Set<Character> set = new HashSet<>();

        while(right < s.length()) {
            char ch = s.charAt(right);
            if(!set.contains(ch)) {
                set.add(ch);
                maxLen = Math.max(maxLen, set.size());
                right++;
            }else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxLen;
    }
}