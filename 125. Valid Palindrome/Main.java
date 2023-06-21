class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder str = new StringBuilder();
        int sLen = s.length();
        for(int i=0; i<sLen; i++){
            char curr = s.charAt(i);
            if(curr>='A' && curr<='Z'){
                curr+=32;
            }
            if(!(curr>='0' && curr<='9' || curr>='a' && curr<='z')){
                continue;
            }else {
                str.append(curr);
            }
        }
        return str.toString().equals(str.reverse().toString());
    }
}