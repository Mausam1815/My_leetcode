class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCnt = 0;
        int currCnt = 0;

        for(int num : nums) {
            if(num == 1) {
                currCnt++;
            }else {
                currCnt = 0;
            }
            maxCnt = Math.max(maxCnt, currCnt);
        }
        return maxCnt;
    }
}