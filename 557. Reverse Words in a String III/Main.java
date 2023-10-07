class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");

        StringBuilder sb = new StringBuilder();

        for(String word : arr) {
            StringBuilder rev = new StringBuilder(word);
            sb.append(rev.reverse()).append(" ");
        }
        return sb.toString().trim();
    }
}