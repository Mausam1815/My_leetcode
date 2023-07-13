class Solution {
    public int maximumCount(int[] nums) {
        if(nums.length == 0 || nums.length == 1){
            return nums.length;
        }
        int l = 0;
        int r = nums.length - 1;
        int firstIdx = findFirstZero(nums, 0, nums.length - 1);
        int lastIdx = findLastZero(nums, 0, nums.length - 1);
        int posIdx = 0;
        if(firstIdx == -1 || lastIdx == -1) {
            while(l <= r){
                int mid = l + (r - l)/ 2;
                if(nums[mid] < 0 && (mid == nums.length - 1 || nums[mid + 1] > 0)) {
                    posIdx = mid + 1;
                    break;
                }else if(nums[mid] < 0) {
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }
            }
            int negCnt = posIdx - 0;
            int posCnt = nums.length - posIdx;
            return Math.max(negCnt, posCnt);
        }
        int negCount = firstIdx - 0;
        int posCount = (nums.length - 1) - lastIdx;
        return Math.max(negCount, posCount);
    }
    public int findFirstZero(int[] nums, int l, int r) {
        
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] == 0 && (mid == 0 || nums[mid - 1] != 0)) {
                return mid;
            }else if(nums[mid] < 0){
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return -1;
    }
    public int findLastZero(int[] nums, int l, int r) {
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(nums[mid] == 0 && (mid == nums.length - 1 || nums[mid + 1] != 0)){
                return mid;
            }else if(nums[mid] <= 0){
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return -1;
    }
}