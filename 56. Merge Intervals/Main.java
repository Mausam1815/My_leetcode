class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        ArrayList<int[]> merged = new ArrayList<>();

        for(int[] interval : intervals) {
            if(merged.size() == 0) {
                merged.add(interval);
            }else {
                int[] prevInterval = merged.get(merged.size() - 1);
                if(interval[0] <= prevInterval[1]) {
                    prevInterval[1] = Math.max(interval[1], prevInterval[1]);
                }else {
                    merged.add(interval);
                }
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}