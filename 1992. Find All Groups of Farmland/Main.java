class Solution {
    public int[][] findFarmland(int[][] land) {
        // arraylist for storinf ans arrays
        ArrayList<int[]> result = new ArrayList<>();
        // traverse over matirx
        for(int i=0; i<land.length; i++) {
            for(int j=0; j<land[0].length; j++) {
                // if the land is farmland
                if(land[i][j] == 1) {
                    int[] arr = {i, j, -1, -1};
                    dfs(land, arr, i, j);
                    result.add(arr);
                }
            }
        }
        int[][] finalRes = new int[result.size()][4];
        for(int i=0; i<result.size(); i++) {
            finalRes[i] = result.get(i);
        }
        return finalRes;
    }
    public void dfs(int[][] land, int[] arr, int i, int j) {
        // base case 
        if(i < 0 || j < 0 || i >= land.length || j >= land[0].length || land[i][j] != 1) {
            return;
        }

        if(arr[2] < i) {
            arr[2] = i;
        }
        if(arr[3] < j) {
            arr[3] = j;
        }

        // mark the visited
        land[i][j] = -1;

        dfs(land, arr, i + 1, j);
        dfs(land, arr, i - 1, j);
        dfs(land, arr, i, j + 1);
        dfs(land, arr, i, j - 1);
    }
}