class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> groupsMap = new HashMap<>();
        
        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];
            
            if (!groupsMap.containsKey(size)) {
                groupsMap.put(size, new ArrayList<>());
            }
            
            groupsMap.get(size).add(i);
            
            if (groupsMap.get(size).size() == size) {
                result.add(new ArrayList<>(groupsMap.get(size)));
                groupsMap.get(size).clear();
            }
        }
        
        return result;
    }
}