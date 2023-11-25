class Solution {
    public int largestAltitude(int[] gain) {
        int sum = 0;
        int max = sum;

        for(int num : gain) {
            sum += num;
            max = Math.max(max, sum);
        }
        return max;
    }
}