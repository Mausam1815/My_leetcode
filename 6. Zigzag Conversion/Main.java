class Solution {
    public String convert(String s, int numRows) {
        if(numRows == s.length() || numRows == 1){
            return s;
        }
        StringBuilder[] rows = new StringBuilder[numRows];
        for(int i=0; i<numRows; i++){
            rows[i] = new StringBuilder();
        }
        int currRow = 0;
        boolean goDown = false;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            rows[currRow].append(ch);
            if(currRow == 0 || currRow == numRows-1){
                goDown = !goDown;
            }
            currRow += goDown ? 1 : -1;
        }
        StringBuilder result = new StringBuilder();
        for(StringBuilder r : rows){
            result.append(r);
        }
        return result.toString();
    }
}