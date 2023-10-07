class Solution {
    public boolean winnerOfGame(String colors) {
        int count = 0;
        for(int i=1; i<colors.length()-1; i++) {
            char ch = colors.charAt(i);
            if(ch == 'A') {
                if(colors.charAt(i-1) == ch && colors.charAt(i+1) == ch) {
                    count++;
                }
            }else if(ch == 'B') {
                if(colors.charAt(i-1) == ch && colors.charAt(i+1) == ch) {
                    count--;
                }
            }
        }
        return (count > 0) ? true : false;
    }
}