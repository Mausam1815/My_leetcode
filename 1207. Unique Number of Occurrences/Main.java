class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : arr) {
            if(map.containsKey(num)) {
                map.put(num,  map.getOrDefault(num, 0) + 1);
            }else {
                map.put(num, 1);
            }
        }

        HashSet<Integer> set = new HashSet<>();
        for(int occ : map.values()) {
            if(set.contains(occ)) {
                return false;
            }else {
                set.add(occ);
            }
        }
        return true;
    }
}