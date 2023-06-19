class Solution {
    public boolean isPalindrome(int x) {
        boolean palindrome=false;
        int palin=0, temp=x;
        while(temp>0){
            int rem=temp%10;
            palin=(palin*10)+rem;
            temp/=10;
        }
        if(palin==x){
            palindrome=true;
        }
        return palindrome;
    }
}