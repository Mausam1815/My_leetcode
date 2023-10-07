class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        if (numRows == 0) {
            return triangle;
        }

        // Initialize the first row with a single element '1'
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum - 1);

            // The first element in each row is '1'
            row.add(1);

            // Calculate the values for the middle elements of the row
            for (int j = 1; j < rowNum; j++) {
                int sum = prevRow.get(j - 1) + prevRow.get(j);
                row.add(sum);
            }

            // The last element in each row is '1'
            row.add(1);

            // Add the current row to the triangle
            triangle.add(row);
        }

        return triangle;
    }
}