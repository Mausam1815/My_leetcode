class Solution {
    public String reverseVowels(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(isVowel(c)) {
                st.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(isVowel(c)) {
                sb.append(st.pop());
            }else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
    public boolean isVowel(char c) {
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }else if(c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return true;
        }else {
            return false;
        }
    }
}