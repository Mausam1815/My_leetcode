class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            System.out.print(left +" " + right);
            int mid = left + (right - left) / 2;
            System.out.println(mid);

            if (nums[mid] > nums[right]) {
                // If nums[mid] > nums[right], the minimum element is in the right half.
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                // If nums[mid] < nums[right], the minimum element is in the left half.
                right = mid;
            } else {
                // If nums[mid] == nums[right], we cannot determine which half the minimum is in,
                // so we simply decrement the right pointer to eliminate duplicates.
                right--;
            }
        }

        return nums[left];
    }
}