class Solution {
    public boolean canCross(int[] stones) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        for(int i=0; i<stones.length; i++) {
            map.put(stones[i], new HashSet<>());
        }

        map.get(stones[0]).add(1);

        for(int i=0; i<stones.length; i++) {
            int curr = stones[i];
            HashSet<Integer> validJumps = map.get(curr);

            for(int jump : validJumps) {
                int newPos = curr + jump;
                if(newPos == stones[stones.length-1]) {
                    return true;
                }
                if(map.containsKey(newPos)) {
                    if(jump - 1 > 0) {
                        map.get(newPos).add(jump - 1);
                    }
                    map.get(newPos).add(jump);
                    map.get(newPos).add(jump + 1);
                }
            }
        }
        return false;
    }
}