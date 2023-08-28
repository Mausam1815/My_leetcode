class Solution {
    public boolean increasingTriplet(int[] nums) {
        int fMin = Integer.MAX_VALUE;
        int sMin = Integer.MAX_VALUE;
        
        for(int num : nums) {
            if(num <= fMin) {
                fMin = num;
            }else if(num <= sMin) {
                sMin = num;
            }else {
                return true;
            }
        }
        return false;
    }
}