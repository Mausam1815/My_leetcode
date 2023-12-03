class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int len1 = 0;
        int len2 = 0;
        for(String str : word1) {
            len1 += str.length();
        }
        for(String str : word2) {
            len2 += str.length();
        }
        if(len1 != len2) {
            return false;
        }
        
        int i1 = 0;
        int i2 = 0;

        for(String str : word1) {
            for(char c : str.toCharArray()) {
                if(c != word2[i2].charAt(i1)) {
                    return false;
                }
                i1++;

                if(i1 == word2[i2].length()) {
                    i1 = 0;
                    i2++;
                }
            }
        }
        return true;
    }
}