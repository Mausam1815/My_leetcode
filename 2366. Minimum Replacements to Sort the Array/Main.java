class Solution {
    public long minimumReplacement(int[] nums) {
        long ans = 0;
        int n = nums.length;
        int prev = nums[n-1];

        for(int i=n-1; i>=0; i--) {
            int delCount = nums[i]/prev;
            if(nums[i] % prev != 0) {
                delCount++;
                prev = nums[i] / delCount;
            }
            // if(nums[i] % prev != 0) {
            //     prev = nums[i] / delCount;;
            // }
            ans += delCount - 1;
        }
        return ans;
    }
}