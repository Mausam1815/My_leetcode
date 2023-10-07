class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int cnt0 = 0;
        int maxCnt = 0;

        for(int right=0; right<nums.length; right++) {
            if(nums[right] == 0) {
                cnt0++;
            }
            while(cnt0 > k) {
                if(nums[left] == 0){
                    cnt0--;
                }
                left++;
            }


            maxCnt = Math.max(maxCnt, right - left + 1);
        }

        return maxCnt;
    }
}