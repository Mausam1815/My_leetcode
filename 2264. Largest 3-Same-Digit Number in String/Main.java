class Solution {
    public String largestGoodInteger(String num) {
        int maxDigit = -1;
        String ans = "";

        for(int i=0; i<num.length()-2; i++) {
            char currDigit = num.charAt(i);
            if(currDigit == num.charAt(i+1) && currDigit == num.charAt(i+2)) {
                int digit = currDigit - '0';
                if(digit > maxDigit) {
                    maxDigit = digit;
                    ans = "" + digit + digit + digit;
                }
            }
        }
        return ans;
    }
}