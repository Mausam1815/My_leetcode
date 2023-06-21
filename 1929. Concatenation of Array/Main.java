// class Solution {
//     public int[] getConcatenation(int[] nums) {
//         int nums1=nums.length;
//         int nums2=nums.length;
//         int[] result = new int[nums1+nums2];
//         System.arraycopy(nums, 0, result, 0, nums1);
//         System.arraycopy(nums, 0, result, nums1, nums2);
//         return result;
//     }
// }
class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] res = new int[2*n];
        for(int i=0; i<n; i++){
            res[i] = nums[i];
            res[i+n] = nums[i];
        }
        return res;
    }
}