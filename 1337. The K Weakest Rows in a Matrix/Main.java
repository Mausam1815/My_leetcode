class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        // Create an array to store the number of soldiers in each row.
        int[] soldierCounts = new int[m];

        // Populate the soldierCounts array.
        for (int i = 0; i < m; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    count++;
                } else {
                    break; // Soldiers appear before civilians, so we can break early.
                }
            }
            soldierCounts[i] = count;
        }

        // Create a list of row indices and sort them based on the soldier counts.
        List<Integer> rowIndices = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            rowIndices.add(i);
        }
        rowIndices.sort((a, b) -> {
            int diff = soldierCounts[a] - soldierCounts[b];
            if (diff != 0) {
                return diff;
            } else {
                return a - b; // If soldier counts are the same, sort by row index.
            }
        });

        // Convert the list of row indices to an array and return the first k elements.
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = rowIndices.get(i);
        }

        return result;
    }
}