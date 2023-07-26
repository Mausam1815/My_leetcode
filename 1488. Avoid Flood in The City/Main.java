class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1); // Initialize ans with -1

        Map<Integer, Integer> lastFilledDay = new HashMap<>();
        TreeSet<Integer> dryDays = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            int lake = rains[i];
            if (lake > 0) { // Rainy day
                if (lastFilledDay.containsKey(lake)) {
                    // Find the next available day to dry the lake
                    Integer dryDay = dryDays.ceiling(lastFilledDay.get(lake));
                    if (dryDay == null) {
                        return new int[0]; // Impossible to avoid flood, return empty array
                    }
                    ans[dryDay] = lake; // Choose the day to dry the lake
                    dryDays.remove(dryDay);
                }
                lastFilledDay.put(lake, i);
            } else { // Dry day
                dryDays.add(i);
            }
        }

        // If there are still dry days, we can choose any day to dry the remaining lakes
        for (int i : dryDays) {
            ans[i] = 1; // For example, we choose lake 1, but it can be any non-filled lake
        }

        return ans;
    }
}