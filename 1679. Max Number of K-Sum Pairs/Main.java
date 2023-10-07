class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int l=0;
        int r=nums.length-1;
        int operations = 0;

        while(l < r) {
            int sum = nums[l] + nums[r];
            if(sum == k) {
                l++;
                r--;
                operations++;
            }else if(sum < k) {
                l++;
            }else {
                r--;
            }
        }
        return operations;
    }
}