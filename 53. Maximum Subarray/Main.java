class Solution {
    public int maxSubArray(int[] nums) {
        // using kadane's algorithm
        int sum = 0;
        int maxSum = nums[0];
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            maxSum = Math.max(maxSum, sum);
            if(sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }
}
// divide and conquer approach
class Solution {
    public int maxSubArray(int[] nums) {
        return maxSubArrayHelper(nums, 0, nums.length-1);
    }
    public int maxSubArrayHelper(int[] nums, int left, int right) {
        if(left == right) {
            return nums[left];
        }
        int mid = (left + right) / 2;
        int leftSum = maxSubArrayHelper(nums, left, mid);
        int rightSum = maxSubArrayHelper(nums, mid + 1, right);
        int subarraySum = maxSubarraySum(nums, left,  mid, right);

        return Math.max(Math.max(leftSum, rightSum), subarraySum);
    }
    public int maxSubarraySum(int[] nums, int left, int mid, int right) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=mid; i>=left; i--) {
            sum += nums[i];
            leftSum = Math.max(leftSum, sum);
        }

        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        for(int i = mid+1; i<=right; i++) {
            sum += nums[i];
            rightSum = Math.max(rightSum, sum);
        }

        return leftSum + rightSum;
    }
}