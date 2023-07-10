class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> fmap = new HashMap<>();
        for(char c : magazine.toCharArray()){
             fmap.put(c, fmap.getOrDefault(c, 0) + 1);
        }
        for(char c : ransomNote.toCharArray()){
            if(!fmap.containsKey(c)){
                return false;
            }
            if(fmap.get(c) == 0){
                return false;
            }
            fmap.put(c, fmap.get(c) - 1);
        }
        return true;
    }
}