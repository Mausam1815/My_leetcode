class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int[] ps = new int[nums.length];
        ps[0] = nums[0];
        for(int i=1; i<nums.length; i++) {
            ps[i] = ps[i-1] + nums[i];
        }
        double avg = ((double)ps[k-1])/k;
        int l = 1;
        int r = k;

        while(r < nums.length) {
            double currAvg = ((double) ps[r] - ps[l-1]) / k;
            avg = Math.max(avg, currAvg);
            l++;
            r++;
        }
        return avg;
    }
}