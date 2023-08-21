class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                String substring = s.substring(0, i);
                StringBuilder constructedString = new StringBuilder();
                
                for (int j = 0; j < n / i; j++) {
                    constructedString.append(substring);
                }
                
                if (constructedString.toString().equals(s)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}