class Solution {
    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        Random rand = new Random();

        while (left <= right) {
            int pivotIndex = left + rand.nextInt(right - left + 1);
            int newPivotIndex = partition(nums, left, right, pivotIndex);

            if (newPivotIndex == nums.length - k) {
                return nums[newPivotIndex];
            } else if (newPivotIndex > nums.length - k) {
                right = newPivotIndex - 1;
            } else {
                left = newPivotIndex + 1;
            }
        }

        return -1; // k is out of bounds
    }
    int partition(int[] nums, int left, int right, int pivotIndex) {
        int pivotValue = nums[pivotIndex];
        swap(nums, pivotIndex, right);

        int storeIndex = left;
        for (int i = left; i < right; i++) {
            if (nums[i] < pivotValue) {
                swap(nums, i, storeIndex);
                storeIndex++;
            }
        }

        swap(nums, storeIndex, right);
        return storeIndex;
    }
	void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}