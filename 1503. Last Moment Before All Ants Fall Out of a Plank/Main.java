class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int maxLeft = Integer.MIN_VALUE;
        int minRight = Integer.MAX_VALUE;

        for(int num : left) {
            maxLeft = Math.max(maxLeft, num);
        }
        for(int num : right) {
            minRight = Math.min(minRight, num);
        }

        return Math.max(maxLeft, n - minRight);
    }
}