class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int[] count = new int[nums.length];
        int[] idx = new int[nums.length];

        for(int i=0; i<nums.length; i++){
            idx[i] = i;
        }

        mergeSort(nums, idx, count, 0, nums.length-1);

        for(int i=0; i<count.length; i++){
            res.add(count[i]);
        }
        return res;
    }
    void mergeSort(int[] nums, int[] idx, int[] count, int start, int end){
        if(start >= end){
            return;
        }

        int mid = start + (end - start) / 2;

        mergeSort(nums, idx, count, start, mid);
        mergeSort(nums, idx, count, mid+1, end);

        merge(nums, idx, count, start, mid, end);
    }
    void merge(int[] nums, int[] idx, int[] count, int start, int mid, int end){
        int[] merged = new int[end - start +1];
        int left = start;
        int right = mid + 1;
        int mergedIdx = 0;
        int smallerRightCnt = 0;

        while(left <= mid && right <= end){
            if(nums[idx[right]] < nums[idx[left]]){
                smallerRightCnt++;
                merged[mergedIdx++] = idx[right++];
            }else {
                count[idx[left]] += smallerRightCnt;
                merged[mergedIdx++] = idx[left++];
            }
        }

        while(left <= mid){
            count[idx[left]] += smallerRightCnt;
            merged[mergedIdx++] = idx[left++];
        }
        while(right <= end){
            merged[mergedIdx++] = idx[right++];
        }

        for(int i=start; i<=end; i++){
            idx[i] = merged[i - start];
        }
    }
}