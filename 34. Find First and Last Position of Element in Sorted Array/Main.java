class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int firstOcc = findFirstOcc(nums, target);

        if(firstOcc == -1){
            return result;
        }

        int lastOcc = findLastOcc(nums, target);
        result[0] = firstOcc;
        result[1] = lastOcc;
        return result;

    }
    public int findLastOcc(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        int lastOcc = -1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(nums[mid] <= target){
                if(nums[mid] == target){
                    lastOcc = mid;
                }
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return lastOcc;
    }
    public int findFirstOcc(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        int firstOcc = -1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] >= target){
                if(nums[mid] == target){
                    firstOcc = mid;
                }
                right = mid-1;
            }else {
                left = mid + 1;
            }
        }
        return firstOcc;
    }
}