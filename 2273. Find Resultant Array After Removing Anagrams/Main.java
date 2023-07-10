class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        String prev = "";
        for(String s : words){
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            if(!sortedStr.equals(prev)){
                ans.add(s);
                prev = sortedStr;
            }
        }
        return ans;
    }
}