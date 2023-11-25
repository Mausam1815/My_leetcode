class Solution {
    public int[] sortByBits(int[] arr) {
        Arrays.sort(arr); // Sort the array in ascending order first
        int[] count = new int[10001]; // To store the count of set bits for each number from 0 to 10000
        int[] result = new int[arr.length];
        int index = 0;

        for (int num : arr) {
            count[num] = Integer.bitCount(num);
        }

        for (int i = 0; i < 15; i++) {
            for (int num : arr) {
                if (count[num] == i) {
                    result[index++] = num;
                }
            }
        }

        return result;
    }
}