class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int targetFrequency = n / 4;

        for (int i = 0; i < n; i++) {
            int count = 1;
            while (i < n - 1 && arr[i] == arr[i + 1]) {
                count++;
                i++;
            }
            if (count > targetFrequency) {
                return arr[i];
            }
        }

        return -1; // No majority element found
    }
}