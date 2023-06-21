class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedArray = new int[nums1.length + nums2.length];
        int i=0, j=0, k=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<=nums2[j]){
                mergedArray[k] = nums1[i];
                i++;
            }else {
                mergedArray[k] = nums2[j];
                j++;
            }
            k++;
        }
        while(i<nums1.length){
            mergedArray[k] = nums1[i];
            i++;
            k++;
        }
        while(j<nums2.length){
            mergedArray[k] = nums2[j];
            j++;
            k++;
        }
        int n = mergedArray.length;
        if(n % 2 == 0){
            double median = (mergedArray[n/2] + mergedArray[(n/2)-1])/2.0;
            return median;
        }else {
            double median = mergedArray[n/2];
            return median;
        }
    }
}